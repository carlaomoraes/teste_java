package br.com.taskcontroller.Service;

import br.com.taskcontroller.Excecoes.BusinessRuleException;
import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Projection.CabecalhoProjection;
import br.com.taskcontroller.Record.Sprint.SprintDataDTO;
import br.com.taskcontroller.Record.Sprint.SprintListagemDTO;
import br.com.taskcontroller.Record.Sprint.TarefaQuadroDTO;
import br.com.taskcontroller.Record.Tarefa.TarefaConsultaDTO;
import br.com.taskcontroller.Respository.SprintRepository;
import br.com.taskcontroller.Respository.StatusEntidadesRepository;
import br.com.taskcontroller.Respository.StatusTransicaoRepository;
import br.com.taskcontroller.Respository.TarefaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SprintService {

    private final SprintRepository sprintRepository;
    private final EmpreendimentoService empreendimentoService;
    private final StatusEntidadesService statusEntidadesService;
    private final StatusEntidadesRepository statusEntidadesRepository;
    private final StatusTransicaoRepository statusTransicaoRepository;
    private final TarefaRepository tarefaRepository;

    public SprintService(
                        TarefaRepository tarefaRepository,
                         SprintRepository sprintRepository,
                         EmpreendimentoService empreendimentoService,
                         StatusEntidadesService statusEntidadesService,
                         StatusEntidadesRepository statusEntidadesRepository,
                         StatusTransicaoRepository statusTransicaoRepository
                         ) {
        this.tarefaRepository = tarefaRepository;
        this.sprintRepository = sprintRepository;
        this.empreendimentoService = empreendimentoService;
        this.statusEntidadesService = statusEntidadesService;
        this.statusEntidadesRepository = statusEntidadesRepository;
        this.statusTransicaoRepository = statusTransicaoRepository;

    }

    public Sprint salvar(Sprint sprint) {
        return sprintRepository.save(sprint);
    }


    public List<SprintListagemDTO> listar(Long idempreendimento) {
       return sprintRepository.listar(idempreendimento);
    }

    public Sprint atualizar(Sprint Sprint) {
        return sprintRepository.save(Sprint);
    }

    public void excluir(Long idSprint) {
        sprintRepository.deleteById(idSprint);
    }

    public Sprint buscarPorId(Long idSprint) {
        return sprintRepository.findById(idSprint).orElseThrow(() -> new RuntimeException("Sprint não encontrado"));
    }

    public boolean existeSobreposicao(Long idEmpreendimento,Long idSprint,
                                      LocalDate dataInicio,LocalDate dataFim) {
        return sprintRepository.buscaSprintPorIntervalo(dataInicio,dataFim,idEmpreendimento, idSprint) > 0;
    }

    public CabecalhoProjection montaCabecalho(Long idEmpreendimento,Long idSprint,LocalDate dataInicio,LocalDate dataFim) {
        return sprintRepository.montaCabecalho(idEmpreendimento,idSprint,dataInicio,dataFim);
    }

    private LocalDate calcularDataFim(LocalDate inicio, int duracao) {
        LocalDate data = inicio;
        int dias = 0;
        while (dias < duracao) {
            if (!ehFimDeSemana(data)) {
                dias++;
            }
            if (dias < duracao) {
                data = data.plusDays(1);
            }
        }
        return data;
    }

    private boolean ehFimDeSemana(LocalDate data) {
        DayOfWeek dia = data.getDayOfWeek();
        return dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY;
    }

    /*
    Procura uma sprint várida
    Se achar, retorna
    Senão, cria

     */
    public Optional<SprintDataDTO> carregarValida(Long idEmpreendimento, Long TIPO_ENTIDADE) {
        Optional<SprintDataDTO> sprintValida = sprintRepository.buscarSprintValida(idEmpreendimento,LocalDate.now());
        StatusEntidades statusEntidades = statusEntidadesService.buscarPorId(statusEntidadesService.achaOrigem(TIPO_ENTIDADE));

        if (sprintValida.isPresent()) {
            return sprintValida;
        }
        // Não existe sprint válida
        Sprint sprint = new Sprint();
        Empreendimento empreendimento = empreendimentoService.buscarPorId(idEmpreendimento);
        int duracao = empreendimento.getDuracao_sprint();

        sprint.setEmpreendimento(empreendimento);

        LocalDate dataInicio = LocalDate.now();
        sprint.setDtiniciosprint(dataInicio);
        LocalDate dataFim = calcularDataFim(dataInicio,duracao);
        sprint.setDtfinalsprint(dataFim);
        sprint.setVisivel(true);

        sprint.setDescsprint("SPRINT NOVA");
        sprint.setStatus(statusEntidades);

        Sprint novaSprint = sprintRepository.save(sprint);

        // Retorna a sprint recém-criada
        return Optional.of(new SprintDataDTO(
                novaSprint.getIdsprint(),
                idEmpreendimento,
                novaSprint.getDescsprint(),
                novaSprint.getDtiniciosprint(),
                novaSprint.getDtfinalsprint(),
                novaSprint.isVisivel(),
                duracao,
                novaSprint.getStatus().getIdstatus(),
                novaSprint.getStatus().getDescstatus(),
                novaSprint.getStatus().getCor()));
    }

    public List<SprintDataDTO> carregarSprints(Long idEmpreendimento) {
        return sprintRepository.buscarSprintAtiva(idEmpreendimento);
    }

    @Transactional
    public void excluirDoRoadmap(Long idSprint, Long idEstoria) {
        sprintRepository.excluirDoRoadmap(idSprint, idEstoria);
    }

    public int retornaOrdem(Long idSprint) {
        return sprintRepository.retornaOrdem(idSprint);
    }

    public SprintListagemDTO buscar(@Param("idSprint") Long idSprint) {
        return sprintRepository.buscar(idSprint);
    }

    @Transactional
    public void alterarStatus(Long idSprint, Long idStatusDestino) {
        Sprint sprint = sprintRepository.findById(idSprint).orElseThrow(() -> new BusinessRuleException("Sprint não encontrada."));
        Long idStatusOrigem = sprint.getStatus().getIdstatus();
        boolean transicaoPermitida = statusTransicaoRepository
                .existsByStatusOrigemIdstatusAndStatusDestinoIdstatus(
                        idStatusOrigem,
                        idStatusDestino
                );

        if (!transicaoPermitida) {
            throw new BusinessRuleException("Transição de status não permitida.");
        }

        StatusEntidades destino = statusEntidadesRepository
                .findById(idStatusDestino)
                .orElseThrow(() ->
                        new BusinessRuleException("Status não encontrado."));

        sprint.setStatus(destino);

        sprintRepository.save(sprint);
    }

    public List<TarefaQuadroDTO> buscarQuadro(Long idSprint) {
        if (!sprintRepository.existsById(idSprint)) {
            throw new BusinessRuleException("Sprint não encontrada.");
        }
        return tarefaRepository.buscarQuadro(idSprint);
    }

}