package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.DTO.Usuario;
import br.com.taskboard.demo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id) {
        return usuarioRepository.findById(id);
    }

    @GetMapping("/?update={id}")
    @Transactional
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @GetMapping("delete={id}")
    @Transactional
    public void deleteById(@PathVariable Long id) {
        usuarioRepository.delete(usuarioRepository.findById(id));
    }

}
