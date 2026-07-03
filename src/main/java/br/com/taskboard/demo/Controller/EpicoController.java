package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Epico;
import br.com.taskboard.demo.Modelo.Prioridades;
import br.com.taskboard.demo.Modelo.StatusEntidades;
import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.EpicoRepository;
import br.com.taskboard.demo.Service.EpicoService;
import br.com.taskboard.demo.Service.PrioridadesService;
import br.com.taskboard.demo.Service.StatusEntidadesService;
import br.com.taskboard.demo.Service.UsuarioService;
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
    private StatusEntidadesService statusService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PrioridadesService prioridadesService;

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
    public ResponseEntity<Epico> salvar(@RequestBody Epico epico) {
        StatusEntidades statusEntidades = statusService.buscarPorId(epico.getStatus().getIdstatus());
        if (statusEntidades == null) {
            return ResponseEntity.notFound().build();
        }
        epico.setStatus(statusEntidades);
        Usuario usuario = usuarioService.buscarPorId(epico.getResponsavel().getIdusuario());
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        epico.setResponsavel(usuario);
        Prioridades prioridades = prioridadesService.buscarPorId(epico.getPrioridade().getIdprioridade());
        if (prioridades == null) {
            return ResponseEntity.notFound().build();
        }
        epico.setPrioridade(prioridades);
        return ResponseEntity.ok(service.salvar(epico));
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