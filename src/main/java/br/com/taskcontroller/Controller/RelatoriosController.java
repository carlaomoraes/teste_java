package br.com.taskcontroller.Controller;

import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.taskcontroller.Service.RelatoriosService;
import br.com.taskcontroller.Record.Sprint.SprintListagemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.taskcontroller.Service.RelatorioSprintPDFService;
import br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {

    @Autowired
    private RelatoriosService service;

    @Autowired
    private RelatorioSprintPDFService relatorioSprintPDFService;



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

    @GetMapping(
            value = "/sprints/periodo/pdf",
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    public ResponseEntity<byte[]> gerarPDFPorPeriodo(
            @RequestParam LocalDate data_inicio,
            @RequestParam LocalDate data_fim) {

        List<RelatorioSprintDTO> sprints =
                service.relatorioSprintPorPeriodo(data_inicio, data_fim);

        byte[] pdf = relatorioSprintPDFService.gerarPDF(sprints);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=relatorio_sprints.pdf"
                )
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

}