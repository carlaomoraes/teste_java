package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Equipe;
import br.com.taskboard.demo.Modelo.EquipeUsuario;
import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.EquipeRepository;
import br.com.taskboard.demo.Respository.EquipeUsuarioRepository;
import br.com.taskboard.demo.Respository.UsuarioRepository;
import br.com.taskboard.demo.Service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EquipeUsuarioRepository equipeUsuarioRepository;

    @Autowired
    private EquipeService service;

    // BUSCAR POR ID
    @GetMapping("/{idequipe}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idequipe) {
        try {
            Equipe equipe = service.buscarPorId(idequipe);
            return ResponseEntity.ok(equipe);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Equipe não encontrada");
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<Equipe> salvar(@RequestBody Equipe equipe) {

        if (equipe.getIdequipe() == null) {
            return ResponseEntity.ok(service.salvar(equipe));
        }

        Equipe equipeExistente = service.buscarPorId(equipe.getIdequipe());

        if (equipeExistente != null) {
            equipeExistente.setDescequipe(equipe.getDescequipe());
            equipeExistente.setNomeequipe(equipe.getNomeequipe());
            return ResponseEntity.ok(service.salvar(equipeExistente));
        }

        return ResponseEntity.ok(service.salvar(equipe));
    }

    // ATUALIZAR (CORRIGIDO PATH VARIABLE)
    @PutMapping("/atualizar/{idequipe}")
    public ResponseEntity<Equipe> atualizar(
            @PathVariable("idequipe") Long idEquipe,
            @RequestBody Equipe equipe) {

        equipe.setIdequipe(idEquipe);
        return ResponseEntity.ok(service.atualizar(equipe));
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Equipe> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idequipe}")
    public ResponseEntity<String> excluir(@PathVariable Long idequipe) {

        String mensagem = String.format(
                "Não é possível excluir a equipe %d pois ela está vinculada a Sprint.",
                idequipe
        );

        try {
            service.excluir(idequipe);
            return ResponseEntity.ok("Equipe excluída com sucesso!");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(mensagem);
        }
    }

    // =========================
    // MEMBROS DA EQUIPE
    // =========================
    @PostMapping("/{idEquipe}/membros/{idUsuario}")
    public ResponseEntity<?> adicionarMembro(
            @PathVariable Long idEquipe,
            @PathVariable Long idUsuario) {

        Equipe equipe = equipeRepository.findById(idEquipe)
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        EquipeUsuario equipeUsuario = new EquipeUsuario();
        equipeUsuario.setEquipe(equipe);
        equipeUsuario.setUsuario(usuario);

        equipeUsuarioRepository.save(equipeUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // LISTAR MEMBROS (ENTIDADE RELACIONAL)
    @GetMapping("/{idEquipe}/membros")
    public List<EquipeUsuario> listarMembros(@PathVariable Long idEquipe) {
        return equipeUsuarioRepository.listarMembros(idEquipe);
    }

    // LISTAR USUÁRIOS DA EQUIPE
    @GetMapping("/{idEquipe}/usuarios")
    public List<Usuario> listarUsuariosEquipe(@PathVariable Long idEquipe) {
        return equipeUsuarioRepository.buscarUsuariosPorEquipe(idEquipe);
    }

    // USUÁRIOS DISPONÍVEIS
    @GetMapping("/{idEquipe}/usuarios/disponiveis")
    public List<Usuario> listarUsuariosDisponiveis(@PathVariable Long idEquipe) {
        return equipeUsuarioRepository.buscarUsuariosDisponiveis(idEquipe);
    }

    // REMOVER MEMBRO (CORRIGIDO E SIMPLIFICADO)
    @DeleteMapping("/{idEquipe}/membros/{idUsuario}")
    public ResponseEntity<?> removerMembro(
            @PathVariable Long idEquipe,
            @PathVariable Long idUsuario) {

        equipeUsuarioRepository.removerMembro(idEquipe, idUsuario);

        return ResponseEntity.noContent().build();
    }
}