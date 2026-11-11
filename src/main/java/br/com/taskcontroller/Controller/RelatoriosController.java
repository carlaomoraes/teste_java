package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO;
import br.com.taskcontroller.Service.EstoriaService;
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
            @RequestParam LocalDate data_inicio,
            @RequestParam LocalDate data_fim) {
        return ResponseEntity.ok(service.relatorioSprintPorPeriodo(data_inicio, data_fim));
    }

}