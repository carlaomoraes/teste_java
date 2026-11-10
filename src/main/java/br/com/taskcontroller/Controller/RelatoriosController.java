package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO;
import br.com.taskcontroller.Service.EstoriaService;
import br.com.taskcontroller.Service.RelatoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {

    @Autowired
    private RelatoriosService service;

    @GetMapping("/sprints/{idEmpreendimento}")
    public ResponseEntity<List<RelatorioSprintDTO>> listarSprints(
            @PathVariable Long idEmpreendimento) {

        return ResponseEntity.ok(service.relatorioSprintPorEmpreendimento(idEmpreendimento));
    }

}