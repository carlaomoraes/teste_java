package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.DTO.Usuario;
import br.com.taskboard.demo.Repository.UsuarioRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public Usuario save(@RequestBody Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @GetMapping("/listar")
    public List<Usuario> findAll() {

        return usuarioRepository.findAll();
    }

    @GetMapping("/{idUsuario}")
    public Usuario findById(@PathVariable Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    @GetMapping("/?update={idUsuario}")
    @Transactional
    public Usuario update(@PathVariable Long idUsuario, @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @GetMapping("delete={idUsuario}")
    @Transactional
    public void deleteById(@PathVariable Long idUsuario) {

        usuarioRepository.delete(usuarioRepository.findById(idUsuario));
    }
}
