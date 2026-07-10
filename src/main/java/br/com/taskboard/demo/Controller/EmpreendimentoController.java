package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Empreendimento;
import br.com.taskboard.demo.Modelo.Equipe;
import br.com.taskboard.demo.Modelo.StatusEntidades;
import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.EmpreendimentoRepository;
import br.com.taskboard.demo.Service.EmpreendimentoService;
import br.com.taskboard.demo.Service.StatusEntidadesService;
import br.com.taskboard.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empreendimento")
public class EmpreendimentoController {

    @Autowired
    private EmpreendimentoService service;

    @Autowired
    private StatusEntidadesService statusService;
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmpreendimentoRepository  empreendimentoRepository;


    //==========================
    // CRUD
    //==========================

    @GetMapping("/{idEmpreendimento}")
    public ResponseEntity<Empreendimento> buscarPorId(
            @PathVariable Long idEmpreendimento) {
        return ResponseEntity.ok(service.buscarPorId(idEmpreendimento));
    }

    @GetMapping("/listar")
    public List<Empreendimento> listar() {

        return service.listar();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Empreendimento> salvar(
            @RequestBody Empreendimento empreendimento) {
        StatusEntidades statusEntidades = statusService.buscarPorId(empreendimento.getStatus().getIdstatus());
        if (statusEntidades == null) {
            return ResponseEntity.notFound().build();
        }
        empreendimento.setStatus(statusEntidades);
        Usuario usuario = usuarioService.buscarPorId(empreendimento.getIdgestor().getIdusuario());
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        empreendimento.setIdgestor(usuario);
        return ResponseEntity.ok(service.salvar(empreendimento));
    }

    @PutMapping("/atualizar/{idEmpreendimento}")
    public ResponseEntity<Empreendimento> atualizar(
            @PathVariable Long idEmpreendimento,
            @RequestBody Empreendimento empreendimento) {
        Usuario usuario = usuarioService.buscarPorId(empreendimento.getIdgestor().getIdusuario());
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        empreendimento.setIdgestor(usuario);
        StatusEntidades statusEntidades = statusService.buscarPorId(empreendimento.getStatus().getIdstatus());
        if (statusEntidades == null) {
            return ResponseEntity.notFound().build();
        }
        empreendimento.setStatus(statusEntidades);
        return ResponseEntity.ok(service.atualizar(empreendimento));
    }

    @DeleteMapping("/excluir/{idEmpreendimento}")
    // Eclusão lógica
    public ResponseEntity<String> excluir(
            @PathVariable Long idEmpreendimento) {
        service.excluir(idEmpreendimento);

        return ResponseEntity.ok("Excluído com sucesso.");
    }

    //==========================
    // EQUIPES
    //==========================

    @PostMapping("/{idEmpreendimento}/equipes/{idEquipe}")
    public ResponseEntity<Void> adicionarEquipe(
            @PathVariable Long idEmpreendimento,
            @PathVariable Long idEquipe) {

        service.adicionarEquipe(idEmpreendimento, idEquipe);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{idEmpreendimento}/equipes/{idEquipe}")
    public ResponseEntity<Void> removerEquipe(
            @PathVariable Long idEmpreendimento,
            @PathVariable Long idEquipe) {

        service.removerEquipe(idEmpreendimento, idEquipe);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idEmpreendimento}/equipes")
    public List<Equipe> listarEquipes(
            @PathVariable Long idEmpreendimento) {

        return service.listarEquipes(idEmpreendimento);
    }

    @GetMapping("/{idEmpreendimento}/equipes/disponiveis")
    public List<Equipe> listarEquipesDisponiveis(
            @PathVariable Long idEmpreendimento) {

        return service.listarEquipesDisponiveis(idEmpreendimento);
    }
}