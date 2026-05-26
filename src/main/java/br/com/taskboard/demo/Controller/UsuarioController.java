package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PutMapping("/salvar")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }
    @GetMapping("/atualizar={idusuario}")
        public Usuario atualizar(@RequestBody Usuario usuario) {
            return service.atualizar(usuario);
    }

    @GetMapping("/listar")
    public List<Usuario> listar() {
        return service.listar();
    }

    @PutMapping("/{idusuario}")
    public Usuario buscarPorId(@PathVariable Integer idusuario) {
        return service.buscarPorId(idusuario);
    }

    @DeleteMapping("/excluir={idusuario}")
    public void excluir(@PathVariable Long idusuario) {
        service.excluir(idusuario);
    }
}