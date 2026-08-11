package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Excecoes.BusinessRuleException;
import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Record.Ausencia.AusenciaListagemDTO;
import br.com.taskcontroller.Record.SprintDataDTO;
import br.com.taskcontroller.Record.SprintListagemDTO;
import br.com.taskcontroller.Respository.AusenciaProgramadaRepository;
import br.com.taskcontroller.Respository.SprintRepository;
import br.com.taskcontroller.Service.EmpreendimentoService;
import br.com.taskcontroller.Service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sprints")
public class SprintController {

    @Autowired
    private SprintService service;

    @Autowired
    private EmpreendimentoService empreendimentoService;

    @Autowired
    private AusenciaProgramadaRepository ausenciaProgramadaRepository;

    @Autowired
    private SprintRepository sprintRepository;

    // BUSCAR POR ID
    @GetMapping("/{idSprint}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idSprint) {
        try {
            Sprint Sprint = service.buscarPorId(idSprint);
            return ResponseEntity.ok().body(Sprint);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Sprint não encontrada");
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody Sprint sprint) {
        // 1. Valida se o Empreendimento existe
        Long idEmpreendimento = sprint.getEmpreendimento().getIdempreendimento();
        Empreendimento empreendimento = empreendimentoService.buscarPorId(idEmpreendimento);

        if (empreendimento == null) {
            throw new ResourceNotFoundException("Empreendimento não encontrado com ID: " + idEmpreendimento);
        }
        sprint.setEmpreendimento(empreendimento);

        // 2. Regra de Negócio: Trata/Valida Fim de Semana (Opcional, mas recomendado)
        if (isWeekend(sprint.getDtiniciosprint()) || isWeekend(sprint.getDtfinalsprint())) {
            throw new BusinessRuleException("A Sprint não pode iniciar ou terminar em um final de semana.");
        }

        // 3. Regra de Negócio: Checa Sobreposição no Banco
        int numSprint = sprintRepository.buscaSprintPorIntervalo(
                sprint.getDtiniciosprint(),
                sprint.getDtfinalsprint(),
                idEmpreendimento,
                sprint.getIdsprint()
        );

        if (numSprint > 0) {
            throw new BusinessRuleException("Já existe uma Sprint cadastrada para este empreendimento no período informado.");
        }

        // 4. Salva a Sprint
        return ResponseEntity.ok(sprintRepository.save(sprint));

    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idSprint}")
    public ResponseEntity<Sprint> atualizar(@PathVariable Long idSprint,
                             @RequestBody Sprint Sprint) {
        Sprint sprint = service.buscarPorId(idSprint);
        Empreendimento empreendimento = empreendimentoService.buscarPorId(sprint.getEmpreendimento().getIdempreendimento());
        if (empreendimento == null) {
            return ResponseEntity.notFound().build();
        }
        sprint.setEmpreendimento(empreendimento);

        Sprint.setIdsprint(idSprint);
        return ResponseEntity.ok().body(service.atualizar(Sprint));
    }

    // LISTAR
    @GetMapping("/listar/DTO/{idEmpreendimento}")
    public List<SprintListagemDTO> listar(@PathVariable Long idEmpreendimento) {
        return service.listar(idEmpreendimento);
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idSprint}")
    public ResponseEntity<String> excluir(@PathVariable Long idSprint) {
        String Messagem = String.format("Não é possível finalizar esta %s ");
        try {
            Sprint Sprint = service.buscarPorId(idSprint);
            Sprint.setDtfinalsprint(LocalDate.now());
            service.atualizar(Sprint);
            return ResponseEntity.ok().body("Sprint finalizada com sucesso!");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.ok().body(Messagem);
        }
    }
    // LISTAR AUSENCIA
    @GetMapping("/listar_ausencias")
    public List<AusenciaListagemDTO> listarAusencias(@RequestParam("data_inicio") LocalDate data_inicio,
                                                     @RequestParam("data_fim") LocalDate data_fim) {
        return ausenciaProgramadaRepository.buscarAusenciasDaSprint(data_inicio, data_fim);
    }
    // VEJA SPRINT SOBREPOSTA
    @GetMapping("/sprint_sobreposta")
    public boolean verificaSobreposta(
            @RequestParam LocalDate data_inicio,
            @RequestParam LocalDate data_fim,
            @RequestParam Long idempreendimento,
            @RequestParam(required = false) Long idsprint) {

        return service.existeSobreposicao(idempreendimento,idsprint,data_inicio,data_fim);
    }
    // CARREGAR ULTIMA SPRINT DO EMPREENDIMENTO
    @GetMapping("/ultima/{idempreendimento}")
    public Optional<SprintDataDTO> carregarUltima(@PathVariable Long idempreendimento) {
        Optional<SprintDataDTO> ultimaSprint = service.carregaUltima(idempreendimento);
        return ultimaSprint;
    }

    private boolean isWeekend(LocalDate date) {
        if (date == null)
            return false;
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
    // Todas as funções da sprint atual
    // BUSCAR POR EMPREENDIMENTO
    @GetMapping("/monta_cabecalho")
    public ResponseEntity<?> montaCabecalho(@RequestParam LocalDate data_inicio,
                                          @RequestParam LocalDate data_fim,
                                          @RequestParam Long idempreendimento) {

        return ResponseEntity.ok(montaCabecalho(data_inicio,data_fim,idempreendimento));
    }
}