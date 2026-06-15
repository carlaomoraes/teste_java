package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Service.LoginService;
import br.com.taskboard.demo.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/taskboard")
public class LoginController {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private LoginService loginService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> efetuarLogin(@RequestBody Usuario dadosLogin) {
        // Procura no banco de dados um usuário com o mesmo login E senha passados
        Optional<Usuario> usuarioOp = loginService.autenticar(dadosLogin.getLogin(), dadosLogin.getSenha());

        if (usuarioOp.isPresent()) {
            // Se achou, retorna o objeto do usuário com o status 200 OK
            return ResponseEntity.ok(usuarioOp.get());
        } else {
            // Se não achou, retorna status 401 Unauthorized com uma mensagem de erro
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Login ou senha incorretos.");
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
    @PostMapping("/trocarsenha")
    public ResponseEntity<?> trocarSenha(
            @RequestBody Usuario usuario,
            HttpSession session) {
        Usuario Novousuario = usuarioService.buscarPorId(usuario.getIdusuario());
        if (!encoder.matches(usuario.getSenha(),Novousuario.getSenha())) {
            return ResponseEntity.badRequest().body("Senha atual inválida");
        }
        session.setAttribute("usuario", Novousuario);
        Novousuario.setNome("novousuario");
        Novousuario.setSenha(encoder.encode(usuario.getSenha()));
        Novousuario.setAlterasenha(1);
        usuarioService.salvar(Novousuario);
        return ResponseEntity.ok("Senha alterada");
    }
}