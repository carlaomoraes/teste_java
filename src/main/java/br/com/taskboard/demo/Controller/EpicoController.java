package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Epico;
import br.com.taskboard.demo.Respository.EpicoRepository;
import br.com.taskboard.demo.Service.EpicoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epicos")
public class EpicoController {

    @Autowired
    private EpicoService service;
    @Autowired
    private EpicoRepository epicoRepository;

    // BUSCAR POR ID
    @GetMapping("/{idepico}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idepico) {
        try {
            Epico epico = service.buscarPorId(idepico);
            return ResponseEntity.ok().body(epico);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Épico não encontrado");
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public Epico salvar(@RequestBody Epico epico) {
        if (epico.getIdepico() == null) {
            return service.salvar(epico);
        } else {
            Epico epicoExistente = service.buscarPorId(epico.getIdepico());
            if (epicoExistente != null) {
                epicoExistente.setIdepico(epico.getIdepico());
                epicoExistente.setDescepico(epico.getDescepico());
                epicoExistente.setObsepico(epico.getObsepico());
                epicoExistente.setBloqueado(epico.getBloqueado());
                return service.salvar(epicoExistente);
            } else {
                return service.salvar(epico);
            }
        }
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idepico}")
    public Epico atualizar(@PathVariable Long idepico,
                             @RequestBody Epico epico) {
        epico.setIdepico(idepico);
        return service.atualizar(epico);
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Epico> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idepico}")
    public ResponseEntity<String> excluir(@PathVariable Long idepico) {
        service.excluir(idepico);
        return ResponseEntity.ok().body("Épico excluído com sucesso");
    }
}