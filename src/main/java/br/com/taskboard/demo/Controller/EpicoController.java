package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Excecoes.ViolacaoChaveEstrangeiraException;
import br.com.taskboard.demo.Modelo.Epico;
import br.com.taskboard.demo.Service.EpicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epico")
public class EpicoController {

    @Autowired
    private EpicoService service;

    // BUSCAR POR ID
    @GetMapping("/{idEpico}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idEpico) {
        try {
            Epico Epico = service.buscarPorId(idEpico);
            return ResponseEntity.ok().body(Epico);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Épico não encontrado");
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public Epico salvar(@RequestBody Epico Epico) {
        return service.salvar(Epico);
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idEpico}")
    public Epico atualizar(@PathVariable Long idEpico,
                             @RequestBody Epico Epico) {

        Epico.setIdepico(idEpico);
        return service.atualizar(Epico);
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Epico> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idEpico}")
    public ResponseEntity<String> excluir(@PathVariable Long idEpico) {
        try {
            service.excluir(idEpico);
            return ResponseEntity.ok().body("Épico excluído com sucesso!");
        } catch (ViolacaoChaveEstrangeiraException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}