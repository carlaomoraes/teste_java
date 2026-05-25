package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public Usuario salvar(
            @RequestBody Usuario usuario) {

        return service.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {

        return service.listar();
    }
}