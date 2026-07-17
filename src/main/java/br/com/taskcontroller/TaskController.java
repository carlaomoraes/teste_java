package br.com.taskcontroller;

import br.com.taskcontroller.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    private final UsuarioService usuarioService;

    public TaskController(UsuarioService usuarioService) {
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

