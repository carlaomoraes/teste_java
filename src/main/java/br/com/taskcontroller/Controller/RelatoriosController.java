package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO;
import br.com.taskcontroller.Record.Sprint.SprintListagemDTO;
import br.com.taskcontroller.Service.RelatoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {

    @Autowired
    private RelatoriosService service;

    @GetMapping("/sprints/empreendimento")
    public ResponseEntity<List<RelatorioSprintDTO>> listarSprintsPorEmpreendimento(
            @RequestParam Long idEmpreendimento) {
        return ResponseEntity.ok(service.relatorioSprintPorEmpreendimento(idEmpreendimento));
    }
    @GetMapping("/sprints/id")
    public ResponseEntity<List<RelatorioSprintDTO>> listarSprintsPorSprint(
            @RequestParam List<Long> idSprint) {
        return ResponseEntity.ok(service.relatorioSprintPorID(idSprint));
    }

    @GetMapping("/sprints/periodo")
    public ResponseEntity<List<RelatorioSprintDTO>> listarSprintsPorPeriodo(
            @RequestParam LocalDate data_inicial,
            @RequestParam LocalDate data_final) {
        return ResponseEntity.ok(service.relatorioSprintPorPeriodo(data_inicial, data_final));
    }

    // LISTAR TODAS AS SPRINTS
    @GetMapping("/listar/DTO/Sprints")
    public List<SprintListagemDTO> listarSrints() {
        return service.listarSprints();
    }


}