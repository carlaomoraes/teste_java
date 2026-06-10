package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Sprint;
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
    public Sprint salvar(@RequestBody Sprint Sprint) {
        Sprint.setDtiniciosprint(LocalDate.now());
        return service.salvar(Sprint);
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idSprint}")
    public Sprint atualizar(@PathVariable Long idSprint,
                             @RequestBody Sprint Sprint) {
        Sprint.setIdsprint(idSprint);
        return service.atualizar(Sprint);
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
}