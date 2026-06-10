package br.com.taskboard.demo;

import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Service.UsuarioService;
import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/home")
    public String home(HttpSession session) {

        if(session.getAttribute(
                "usuarioLogado") == null) {

            return "redirect:/index.html";
        }

        return "home";
    }
}

