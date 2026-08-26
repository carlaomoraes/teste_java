package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Mapper.EpicoMapper;
import br.com.taskcontroller.Mapper.EstoriaMapper;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Epico.EpicoConsultaDTO;
import br.com.taskcontroller.Record.Epico.EpicoInclusaoDTO;
import br.com.taskcontroller.Record.Epico.EpicoListagemDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaConsultaDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaInclusaoDTO;
import br.com.taskcontroller.Respository.*;
import br.com.taskcontroller.Service.EpicoService;
import br.com.taskcontroller.Service.PrioridadesService;
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
    private UsuarioService usuarioService;
    @Autowired
    private PrioridadesService prioridadesService;
    @Autowired
    private EpicoEstoriasRepository epicoEstoriasRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EpicoRepository epicoRepository;
    @Autowired
    private PrioridadesRepository prioridadesRepository;

    // BUSCAR POR ID - DTO
    @GetMapping("/DTO/{idepico}")
    public ResponseEntity<EpicoConsultaDTO> buscarPorId(@PathVariable Long idepico) {
        try {
            EpicoConsultaDTO epico = epicoRepository.buscaPorID(idepico);
            return ResponseEntity.ok().body(epico);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<Epico> salvar(@RequestBody EpicoInclusaoDTO dto) {
        Epico epico = EpicoMapper.toEntity(dto);
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
    public List<EpicoListagemDTO> listar() {
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
    // =========================
    @GetMapping("/{idepico}/estorias/{idestoria}")
    public ResponseEntity<?> buscarEstoriaPorId(@PathVariable Long idepico,
                                                @PathVariable Long idestoria) {
        Epico epico = service.buscarPorId(idepico);
        if (epico == null) {
            ResponseEntity.status(HttpStatus.CONFLICT).body("Épico não encontrado");
        }
        EstoriaConsultaDTO estoria = epicoEstoriasRepository.buscarPorId(idestoria);
        if (estoria == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Estória não encontrada");
        }
        return ResponseEntity.ok().body(estoria);
    }
    // LISTAR TODAS ESTÓRIAS POR ÉPICO
    @GetMapping("/{idEpico}/estorias")
    public List<EstoriaConsultaDTO> listarEstoriaPorEpico(@PathVariable Long idEpico) {
        return epicoEstoriasRepository.listaEstoriasPorEpico(idEpico);
    }
//    Epico epico = EpicoMapper.toEntity(dto);
//        return ResponseEntity.ok(service.salvar(epico));

    @PostMapping("/{idEpico}/adicionarEstoria")
    public ResponseEntity<?> adicionarEstoria(
            @PathVariable Long idEpico,
            @RequestBody EstoriaInclusaoDTO dto) {
        Estoria estoria = EstoriaMapper.toEntity(dto);
        return ResponseEntity.ok(epicoEstoriasRepository.save(estoria));

        /*
        Epico epico = service.buscarPorId(idEpico);
        Usuario criador = usuarioRepository.findById(estoria.getCriador().getIdusuario())
                .orElseThrow(() -> new RuntimeException("Usuário criador não encontrado"));
        Usuario responsavel = usuarioRepository.findById(estoria.getResponsavel().getIdusuario())
                .orElseThrow(() -> new RuntimeException("Usuário responsavel não encontrado"));
        estoria.setEpico(epico);
        estoria.setCriador(criador);
        estoria.setResponsavel(responsavel);
        epicoEstoriasRepository.save(estoria);

        return ResponseEntity.status(HttpStatus.CREATED).build(); */
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