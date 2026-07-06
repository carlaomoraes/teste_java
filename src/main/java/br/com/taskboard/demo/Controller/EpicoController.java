package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.*;
import br.com.taskboard.demo.Respository.EpicoEstoriasRepository;
import br.com.taskboard.demo.Respository.EpicoRepository;
import br.com.taskboard.demo.Respository.UsuarioRepository;
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
    @Autowired
    private EpicoEstoriasRepository epicoEstoriasRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

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
    // =========================
    // ESTORIAS POR ÉPICOS
    // =========================
    // BUSCAR POR ID
    @GetMapping("/{idepico}/estorias/{idestorias}")
    public ResponseEntity<?> buscarEstoriaPorId(@PathVariable Long idestoria) {
        try {
            Estoria estoria = epicoEstoriasRepository.buscarPorId(idestoria);
            return ResponseEntity.ok().body(estoria);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Estória não encontrada");
        }
    }
    // LISTAR TODAS ESTÓRIAS POR ÉPICO
    @GetMapping("/{idEpico}/estorias")
    public List<Estoria> listarEstoriaPorEpico(@PathVariable Long idEpico) {
        return epicoEstoriasRepository.buscarEstoriaPorEpico(idEpico);
    }

    @PostMapping("/{idEpico}/adicionarEstoria")
    public ResponseEntity<?> adicionarEstoria(
            @PathVariable Long idEpico,
            @RequestBody Estoria estoria) {
        Epico epico = service.buscarPorId(idEpico);
        Usuario criador = usuarioRepository.findById(estoria.getIdcriador().getIdusuario())
                .orElseThrow(() -> new RuntimeException("Usuário criador não encontrado"));
        Usuario responsavel = usuarioRepository.findById(estoria.getIdresponsavel().getIdusuario())
                .orElseThrow(() -> new RuntimeException("Usuário responsavel não encontrado"));
        estoria.setIdepico(epico);
        estoria.setIdcriador(criador);
        estoria.setIdresponsavel(responsavel);
        epicoEstoriasRepository.save(estoria);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // LISTAR TODAS AS ESTORIAS POR ÉPICO
    // APAGAR UMA ESTORIA
    @DeleteMapping("/{idEpico}/remover/{idEstoria}")
    public ResponseEntity<?> removerMembro(@PathVariable Long idEpico,
                                           @PathVariable Long idEstoria) {
        epicoEstoriasRepository.removerDoEpico(idEpico, idEstoria);
        return ResponseEntity.noContent().build();
    }
}