package br.com.taskcontroller.Service;

import br.com.taskcontroller.Excecoes.BusinessRuleException;
import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Projection.CabecalhoProjection;
import br.com.taskcontroller.Record.SprintListagemDTO;
import br.com.taskcontroller.Respository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

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

    public boolean existeSobreposicao(Long idEmpreendimento,Long idSprint,LocalDate dataInicio,LocalDate dataFim) {
        return sprintRepository.buscaSprintPorIntervalo(dataInicio,dataFim,idEmpreendimento,idSprint) > 0;
    }

    public CabecalhoProjection montaCabecalho(Long idEmpreendimento,Long idSprint,LocalDate dataInicio,LocalDate dataFim) {
        return sprintRepository.montaCabecalho(idEmpreendimento,idSprint,dataInicio,dataFim);
    }
}