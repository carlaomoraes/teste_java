package br.com.taskcontroller.Service;

import br.com.taskcontroller.Excecoes.BusinessRuleException;
import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Projection.CabecalhoProjection;
import br.com.taskcontroller.Record.SprintDataDTO;
import br.com.taskcontroller.Record.SprintListagemDTO;
import br.com.taskcontroller.Respository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SprintService {

    private final SprintRepository sprintRepository;
    private final EmpreendimentoService empreendimentoService;

    public SprintService(SprintRepository sprintRepository, EmpreendimentoService empreendimentoService) {
        this.sprintRepository = sprintRepository;
        this.empreendimentoService = empreendimentoService;
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

    public boolean existeSobreposicao(Long idEmpreendimento,Long idSprint, LocalDate dataInicio,LocalDate dataFim) {
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
    public Optional<SprintDataDTO> carregarValida(Long idEmpreendimento) {
        Optional<SprintDataDTO> sprintValida = sprintRepository.buscarSprintValida(idEmpreendimento,LocalDate.now());
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
        sprint.setAtiva(true);
        sprint.setVisivel(true);

        sprint.setDescsprint("SPRINT NOVA");

        Sprint novaSprint = sprintRepository.save(sprint);

        // Retorna a sprint recém-criada
        return Optional.of(new SprintDataDTO(
                novaSprint.getIdsprint(),
                idEmpreendimento,
                novaSprint.getDescsprint(),
                novaSprint.getDtiniciosprint(),
                novaSprint.getDtfinalsprint(),
                novaSprint.isVisivel(),
                novaSprint.isAtiva(),
                duracao));
    }
}