package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Projection.IndicadorEquipeProjection;
import br.com.taskcontroller.Record.EquipeCardDTO;
import br.com.taskcontroller.Respository.EpicoEstoriasRepository;
import br.com.taskcontroller.Respository.UsuarioRepository;
import br.com.taskcontroller.Service.EpicoService;
import br.com.taskcontroller.Service.PrioridadesService;
import br.com.taskcontroller.Service.StatusEntidadesService;
import br.com.taskcontroller.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/{idepico}/estorias/{idestoria}")
    public ResponseEntity<?> buscarEstoriaPorId(@PathVariable Long idepico,
                                                @PathVariable Long idestoria) {
        Epico epico = service.buscarPorId(idepico);
        if (epico == null) {
            ResponseEntity.status(HttpStatus.CONFLICT).body("Épico não encontrado");
        }
        Estoria estoria = epicoEstoriasRepository.buscarPorId(idepico, idestoria);
        if (estoria == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Estória não encontrada");
        }
        return ResponseEntity.ok().body(estoria);
    }
    // LISTAR TODAS ESTÓRIAS POR ÉPICO
    @GetMapping("/{idEpico}/estorias")
    public List<Estoria> listarEstoriaPorEpico(@PathVariable Long idEpico) {
        return epicoEstoriasRepository.findByIdepico_IdepicoOrderByDescestoria(idEpico);
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