package br.com.taskcontroller.Service;

import br.com.taskcontroller.DTO.Sprint.SprintRequestDTO;
import br.com.taskcontroller.Enums.TipoAlteracao;
import br.com.taskcontroller.Excecoes.BusinessRuleException;
import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Projection.CabecalhoProjection;
import br.com.taskcontroller.Record.Estoria.EstoriaHistoricoDTO;
import br.com.taskcontroller.Record.Sprint.SprintDataDTO;
import br.com.taskcontroller.Record.Sprint.SprintHistoricoDTO;
import br.com.taskcontroller.Record.Sprint.SprintListagemDTO;
import br.com.taskcontroller.Record.Sprint.TarefaQuadroDTO;
import br.com.taskcontroller.Record.Tarefa.TarefaConsultaDTO;
import br.com.taskcontroller.Respository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SprintService {

    @Autowired
    private StatusTransicaoService  statusTransicaoService;

    @Autowired
    private UsuarioService usuarioService;

    private final SprintRepository sprintRepository;
    private final EmpreendimentoService empreendimentoService;
    private final StatusEntidadesService statusEntidadesService;
    private final StatusEntidadesRepository statusEntidadesRepository;
    private final StatusTransicaoRepository statusTransicaoRepository;
    private final TarefaRepository tarefaRepository;
    private final SprintHistoricoRepository sprintHistoricoRepository;
    private final SprintHistoricoService sprintHistoricoService;


    public SprintService(
                        TarefaRepository tarefaRepository,
                        SprintRepository sprintRepository,
                        EmpreendimentoService empreendimentoService,
                        StatusEntidadesService statusEntidadesService,
                        StatusEntidadesRepository statusEntidadesRepository,
                        StatusTransicaoRepository statusTransicaoRepository,
                        SprintHistoricoRepository sprintHistoricoRepository,
                        SprintHistoricoService sprintHistoricoService,
                        UsuarioService usuarioServicee) {
        this.tarefaRepository = tarefaRepository;
        this.sprintRepository = sprintRepository;
        this.empreendimentoService = empreendimentoService;
        this.statusEntidadesService = statusEntidadesService;
        this.statusEntidadesRepository = statusEntidadesRepository;
        this.statusTransicaoRepository = statusTransicaoRepository;
        this.sprintHistoricoRepository = sprintHistoricoRepository;
        this.sprintHistoricoService = sprintHistoricoService;
    }

    @Transactional
    public Sprint salvar(SprintRequestDTO dto) {
        Sprint sprint;
        StatusEntidades statusEntidades = statusEntidadesService.buscarPorId(dto.idstatus());

        if (statusEntidades == null) {
            throw new ResourceNotFoundException(
                    "Status não permitido: " + dto.idstatus()
            );
        }
        if (dto.idsprint() != null && dto.idsprint() > 0) {
            sprint = sprintRepository.findById(dto.idsprint())
                    .orElseThrow(() ->
                            new ResourceNotFoundException(
                                    "Sprint não encontrada: " + dto.idsprint()
                            ));
        } else {
            sprint = new Sprint();
        }

        Empreendimento empreendimento =
                empreendimentoService.buscarPorId(dto.idempreendimento());

        if (empreendimento == null) {
            throw new ResourceNotFoundException(
                    "Empreendimento não encontrado: " + dto.idempreendimento()
            );
        }

        // Validação das datas
        if (dto.dtiniciosprint() == null || dto.dtfinalsprint() == null) {
            throw new BusinessRuleException(
                    "Informe as datas da Sprint."
            );
        }

        if (dto.dtiniciosprint().isAfter(dto.dtfinalsprint())) {
            throw new BusinessRuleException(
                    "A data inicial não pode ser maior que a data final."
            );
        }

        if (isWeekend(dto.dtiniciosprint()) ||
                isWeekend(dto.dtfinalsprint())) {

            throw new BusinessRuleException(
                    "A Sprint não pode iniciar ou terminar em um final de semana."
            );
        }

        // Verifica sobreposição
        int numSprint = sprintRepository.buscaSprintPorIntervalo(
                dto.dtiniciosprint(),
                dto.dtfinalsprint(),
                dto.idempreendimento(),
                dto.idsprint()
        );

        if (numSprint > 0) {
            throw new BusinessRuleException(
                    "Já existe uma Sprint cadastrada para este empreendimento no período informado."
            );
        }

        // Atualiza os campos
        sprint.setDescsprint(dto.descsprint());
        sprint.setDtiniciosprint(dto.dtiniciosprint());
        sprint.setDtfinalsprint(dto.dtfinalsprint());
        sprint.setVisivel(dto.visivel());
        sprint.setEmpreendimento(empreendimento);
        sprint.setStatus(statusEntidades);

        return sprintRepository.save(sprint);
    }

    private boolean isWeekend(LocalDate date) {
        if (date == null)
            return false;
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
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

    public boolean ehFimDeSemana(LocalDate data) {
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
        Random random  = new Random();
        int numero = random.nextInt(100);


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

        sprint.setDescsprint("SPRINT-" + numero);
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


    public List<TarefaQuadroDTO> montaQuadro(Long idSprint) {
        if (!sprintRepository.existsById(idSprint)) {
            throw new BusinessRuleException("Sprint não encontrada.");
        }
        return tarefaRepository.montaQuadro(idSprint);
    }

    @Transactional
    public void alterarStatus(Long idSprint, Long idStatus, Long idUsuario) {
        Sprint sprint = sprintRepository.findById(idSprint).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));

        StatusEntidades statusAnterior = sprint.getStatus();
        StatusEntidades novoStatus = statusEntidadesService.buscaStatusEntidades(idStatus);

        Usuario usuario = usuarioService.buscarPorId(idUsuario);

        // Evita alteração desnecessária
        if (statusAnterior.getIdstatus().equals(novoStatus.getIdstatus())) {
            return;
        }

        // Valida a transição cadastrada no workflow
        statusTransicaoService.validarTransicao(statusAnterior, novoStatus);

        sprint.setStatus(novoStatus);

        sprintHistoricoService.registrar(
                sprint,
                usuario,
                TipoAlteracao.STATUS,
                statusAnterior.getDescstatus(),
                novoStatus.getDescstatus(),
                "Alteração de status da sprint"
        );

        sprintRepository.save(sprint);
    }
    public List<SprintHistoricoDTO> buscarHistorico(Long idSprint) {
        return  sprintHistoricoRepository.listaHistorico(idSprint);
    }

}