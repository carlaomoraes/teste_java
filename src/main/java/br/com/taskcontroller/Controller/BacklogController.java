package br.com.taskcontroller.Controller;


import br.com.taskcontroller.Record.COMBO.EmpreendimentoComboDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaBacklogDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaRoadmapDTO;;
import br.com.taskcontroller.Record.RoadmapOrdemDTO;
import br.com.taskcontroller.Service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/backlog")
public class BacklogController {

    @Autowired
    private BacklogService service;

    @GetMapping("/{idempreendimento}")
    public List<EstoriaBacklogDTO> listar(@PathVariable Long idempreendimento) {
        return service.listar(idempreendimento);
    }
    @GetMapping("/carrega_combo")
    public List<EmpreendimentoComboDTO> carregaCombo() {
        return service.montaComboEmpreendimento();
    }
    @GetMapping("/{idempreendimento}/roadmap")
    public List<EstoriaRoadmapDTO> monntaRoadmap(@PathVariable Long idempreendimento) {
        return service.montaRoadmap(idempreendimento);
    }
    @PutMapping("/reordenar")
    public ResponseEntity<?> reordenar(
            @RequestBody List<RoadmapOrdemDTO> lista) {

        service.reordenar(lista);

        return ResponseEntity.ok().build();
    }
}