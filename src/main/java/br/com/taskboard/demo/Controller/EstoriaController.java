package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Estoria;
import br.com.taskboard.demo.Service.EstoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoria")
public class EstoriaController {

    @Autowired
    private EstoriaService service;

    // BUSCAR POR ID
    @GetMapping("/{idEstoria}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idEstoria) {
        try {
            Estoria Estoria = service.buscarPorId(idEstoria);
            return ResponseEntity.ok().body(Estoria);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Estória não encontrado");
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public Estoria salvar(@RequestBody Estoria Estoria) {

        return service.salvar(Estoria);
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idEstoria}")
    public Estoria atualizar(@PathVariable Long idEstoria,
                           @RequestBody Estoria Estoria) {

        Estoria.setIdestoria(idEstoria);

        return service.atualizar(Estoria);
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Estoria> listar() {

        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idEstoria}")
    public ResponseEntity<String> excluir(@PathVariable Long idEstoria) {
        String Messagem = String.format("Não é possível excluir este %s pois ele está vinculado %s.",Long.toString(idEstoria),"tarefa");
        try {
            service.excluir(idEstoria);
            return ResponseEntity.ok().body("Estoria excluída com sucesso!");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.ok().body(Messagem);
        }
    }
}