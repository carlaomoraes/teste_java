package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.AusenciaProgramada;
import br.com.taskboard.demo.Service.AusenciaProgramadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ausencias")
public class AusenciaProgramadaController {

    @Autowired
    private AusenciaProgramadaService service;

    // BUSCAR POR ID
    @GetMapping("/{idAusenciaProgramada}")
    public ResponseEntity<?> buscarPorId(@PathVariable int idAusenciaProgramada) {
        try {
            AusenciaProgramada AusenciaProgramada = service.buscarPorId(idAusenciaProgramada);
            return ResponseEntity.ok().body(AusenciaProgramada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ausência programada não encontrada");
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public AusenciaProgramada salvar(@RequestBody AusenciaProgramada AusenciaProgramada) {
        return service.salvar(AusenciaProgramada);
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idAusenciaProgramada}")
    public AusenciaProgramada atualizar(@PathVariable int idAusenciaProgramada,
                             @RequestBody AusenciaProgramada AusenciaProgramada) {
        AusenciaProgramada.setId_ausencia(idAusenciaProgramada);
        return service.atualizar(AusenciaProgramada);
    }

    // LISTAR
    @GetMapping("/listar")
    public List<AusenciaProgramada> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idAusenciaProgramada}")
    public ResponseEntity<String> excluir(@PathVariable int idAusenciaProgramada) {
        String Messagem = String.format("Não é possível excluir esta %s pois ela está vinculado %s.",Long.toString(idAusenciaProgramada),"Sprint");
        try {
            service.excluir(idAusenciaProgramada);
            return ResponseEntity.ok().body("Ausência programada excluída com sucesso!");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.ok().body(Messagem);
        }
    }
}