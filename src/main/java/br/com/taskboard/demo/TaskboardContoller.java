package br.com.taskboard.demo;

import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Service.UsuarioService;
import ch.qos.logback.core.model.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskboardContoller {

    private final UsuarioService usuarioService;

    public TaskboardContoller(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/taskboard")
    public String taskboard() {
        return "index";
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> usuario(@PathVariable Integer id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok()
                .header("Custom-Header", "value")
                .body(usuario);
    }
}

