package br.com.taskboard.demo;

import br.com.taskboard.demo.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskContoller {

    private final UsuarioService usuarioService;

    public TaskContoller(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        if(session.getAttribute("usuarioLogado") == null) {
            return "redirect:/index.html";
        }
        return "home";
    }
}

