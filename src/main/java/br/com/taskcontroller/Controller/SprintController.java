package br.com.taskcontroller.Controller;

import br.com.taskcontroller.DTO.Sprint.SprintEstoriaRequestDTO;
import br.com.taskcontroller.DTO.Sprint.SprintRequestDTO;
import br.com.taskcontroller.Excecoes.BusinessRuleException;
import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Ausencia.AusenciaListagemDTO;
import br.com.taskcontroller.Record.Sprint.*;
import br.com.taskcontroller.Respository.AusenciaProgramadaRepository;
import br.com.taskcontroller.Respository.SprintEstoriaRepository;
import br.com.taskcontroller.Respository.SprintRepository;
import br.com.taskcontroller.Service.*;
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
    private BacklogService backlogService;

    @Autowired
    private EmpreendimentoService empreendimentoService;

    @Autowired
    private SprintIndicadoresService sprintIndicadoresService;

    @Autowired
    private AusenciaProgramadaRepository ausenciaProgramadaRepository;


    @Autowired
    private SprintEstoriaRepository sprintEstoriaRepository;

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
    // BUSCAR POR ID - DTO
    @GetMapping("/DTO/{idSprint}")
    public SprintListagemDTO buscarPorIdDTO(@PathVariable Long idSprint) {
        return service.buscar(idSprint);
    }


    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody SprintRequestDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
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
    // RETORNA A ULTIMA SPRINT VALIDA DO EMPREENDIMENTO
    @GetMapping("/valida_ultima/{idempreendimento}")
    public Optional<SprintDataDTO> carregarValida(@PathVariable Long idempreendimento) {
        return service.carregarValida(idempreendimento, 4l);
    }

    // Todas as funções da sprint atual
    @GetMapping("/carregaSprint/DTO/{idEmpreendimento}")
    public List<SprintDataDTO> carregarSprints(@PathVariable Long idEmpreendimento) {
        return service.carregarSprints(idEmpreendimento);
    }

    @PostMapping("/atualiza_backlog")
    public ResponseEntity<?> atualiza_backlog(@RequestBody SprintEstoriaRequestDTO dto) {
        SprintEstoria sprintEstoria = backlogService.atualizar(dto);
        return ResponseEntity.ok(sprintEstoriaRepository.save(sprintEstoria));
    }
    @DeleteMapping("/{idSprint}/{idEstoria}")
    public ResponseEntity<?> excluirDoRoadmap(@PathVariable Long idSprint,@PathVariable Long idEstoria) {
        service.excluirDoRoadmap(idSprint, idEstoria);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{idSprint}/status/{idStatus}/{idUsuario}")
    public ResponseEntity<?> alterarStatus(@PathVariable Long idSprint, @PathVariable Long idStatus,
                                           @PathVariable Long idUsuario) {
        service.alterarStatus(idSprint, idStatus, idUsuario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idSprint}/quadro")
    public List<TarefaQuadroDTO> montaQuadro(@PathVariable Long idSprint) {
        return service.montaQuadro(idSprint);
    }

    @GetMapping("/{idSprint}/indicadores")
    public ResponseEntity<SprintIndicadoresDTO> carregaIndicadores(@PathVariable Long idSprint) {
        return ResponseEntity.ok(sprintIndicadoresService.carregaIndicadores(idSprint));
    }
    @GetMapping("/{idSprint}/historico")
    public List<SprintHistoricoDTO> listarHistorico(@PathVariable Long idSprint) {
        return service.buscarHistorico(idSprint);
    }

}