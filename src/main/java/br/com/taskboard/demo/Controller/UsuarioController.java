package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Excecoes.ViolacaoChaveEstrangeiraException;
import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // BUSCAR POR ID
    @GetMapping("/{idusuario}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idusuario) {
        try {
            Usuario usuario = service.buscarPorId(idusuario);
            return ResponseEntity.ok().body(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário não encontrado");
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public Usuario salvar(@RequestBody Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return service.salvar(usuario);
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idusuario}")
    public Usuario atualizar(@PathVariable Long idusuario,
                             @RequestBody Usuario usuario) {
        usuario.setIdusuario(idusuario);
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return service.atualizar(usuario);
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Usuario> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idusuario}")
    public ResponseEntity<String> excluir(@PathVariable Long idusuario) {
        try {
            service.excluir(idusuario);
            return ResponseEntity.ok().body("Usuário excluído com sucesso!");
        } catch (ViolacaoChaveEstrangeiraException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
    @PostMapping("/trocar-senha")
    public ResponseEntity<?> trocarSenha(@RequestBody Usuario usuario) {
        Usuario novoUsuario = service.buscarPorId(usuario.getIdusuario());
        if (!encoder.matches(novoUsuario.getSenha(), usuario.getSenha())) {
            return ResponseEntity.badRequest().body("Senha atual inválida");
        } else {
            usuario.setSenha(encoder.encode(usuario.getSenha()));
            service.salvar(usuario);
            return ResponseEntity.ok().build();
        }
    }
}