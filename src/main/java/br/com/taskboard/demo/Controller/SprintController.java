package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.AusenciaProgramada;
import br.com.taskboard.demo.Modelo.Empreendimento;
import br.com.taskboard.demo.Modelo.Sprint;
import br.com.taskboard.demo.Modelo.StatusEntidades;
import br.com.taskboard.demo.Respository.AusenciaProgramadaRepository;
import br.com.taskboard.demo.Service.EmpreendimentoService;
import br.com.taskboard.demo.Service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sprints")
public class SprintController {

    @Autowired
    private SprintService service;

    @Autowired
    private EmpreendimentoService empreendimentoService;

    @Autowired
    private AusenciaProgramadaRepository ausenciaProgramadaRepository;


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
    public ResponseEntity<Sprint> salvar(@RequestBody Sprint sprint) {
        Empreendimento empreendimento = empreendimentoService.buscarPorId(sprint.getEmpreendimento().getIdempreendimento());
        if (empreendimento == null) {
            return ResponseEntity.notFound().build();
        }
        sprint.setEmpreendimento(empreendimento);
        return ResponseEntity.ok().body(service.salvar(sprint));
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
    @GetMapping("/listar")
    public List<Sprint> listar() {
        return service.listar();
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
    public List<AusenciaProgramada> listarAusencias(@RequestParam("data_inicio") LocalDate data_inicio,
                                                    @RequestParam("data_fim") LocalDate data_fim) {
        return ausenciaProgramadaRepository.buscarAusenciasDaSprint(data_inicio, data_fim);
    }
}