package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Record.TarefaConsultaDTO;
import br.com.taskcontroller.Service.EstoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estorias")
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
        service.excluir(idEstoria);
        return ResponseEntity.ok().body("Estoria excluída com sucesso!");
    }
}