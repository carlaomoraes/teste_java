package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.Equipe;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Record.EmpreendimentoDTO;
import br.com.taskcontroller.Service.EmpreendimentoService;
import br.com.taskcontroller.Service.UsuarioService;
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
    private UsuarioService usuarioService;



    //==========================
    // CRUD
    //==========================

    @GetMapping("/{idEmpreendimento}")
    public ResponseEntity<Empreendimento> buscarPorId(
            @PathVariable Long idEmpreendimento) {
        return ResponseEntity.ok(service.buscarPorId(idEmpreendimento));
    }

    @GetMapping("/listar")
    public List<EmpreendimentoDTO> listar() {
        return service.listar();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Empreendimento> salvar(
            @RequestBody Empreendimento empreendimento) {
//        StatusEntidades statusEntidades = statusService.buscarPorId(empreendimento.getStatus().getIdstatus());
//        if (statusEntidades == null) {
//            return ResponseEntity.notFound().build();
//        }
//        empreendimento.setStatus(statusEntidades);
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
        Empreendimento novoEmpreendimento = service.buscarPorId(idEmpreendimento);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        if (novoEmpreendimento == null) {
            return ResponseEntity.notFound().build();
        }
        novoEmpreendimento.setIdgestor(usuario);
//        StatusEntidades statusEntidades = statusService.buscarPorId(empreendimento.getStatus().getIdstatus());
//        if (statusEntidades == null) {
//            return ResponseEntity.notFound().build();
//        }
//        novoEmpreendimento.setStatus(statusEntidades);
        return ResponseEntity.ok(service.atualizar(novoEmpreendimento));
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

    @PostMapping("/{idEmpreendimento}/equipes/adicionar/{idEquipe}")
    public ResponseEntity<Void> adicionarEquipe(
            @PathVariable Long idEmpreendimento,
            @PathVariable Long idEquipe) {

        service.adicionarEquipe(idEmpreendimento, idEquipe);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{idEmpreendimento}/equipes/excluir/{idEquipe}")
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