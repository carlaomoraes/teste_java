package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Record.Usuario.UsuarioLoginDTO;
import br.com.taskcontroller.Respository.UsuarioRepository;
import br.com.taskcontroller.Service.LoginService;
import br.com.taskcontroller.Service.UsuarioService;
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
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> efetuarLogin(@RequestBody Usuario dadosLogin) {
        // Procura no banco de dados um usuário com o mesmo login E senha passados
        Optional<UsuarioLoginDTO> usuarioOp = loginService.autenticar(dadosLogin.getLogin(), dadosLogin.getSenha());

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
    public ResponseEntity<?> trocarSenha(@RequestBody Usuario dadosLogin) {
        // 1. Busca o usuário atualizado direto do banco de dados
        Usuario usuario = usuarioRepository.findById(dadosLogin.getIdusuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // 2. 🌟 O PULO DO GATO: Compara a senha digitada (limpa) com a do banco (criptografada)
        if (!encoder.matches(dadosLogin.getSenha(), usuario.getSenha())) {
            return ResponseEntity.badRequest().body("A senha atual digitada está incorreta.");
        }

        // 3. Valida se a nova senha não é igual à antiga
        if (encoder.matches(dadosLogin.getSenha(), usuario.getSenha())) {
            return ResponseEntity.badRequest().body("A nova senha deve ser diferente da senha atual.");
        }

        // 4. Se passou nas validações, criptografa a nova senha antes de salvar
        String novaSenhaCriptografada = encoder.encode(dadosLogin.getSenha());
        usuario.setSenha(novaSenhaCriptografada);
        usuario.setAlterasenha(false);

        usuarioRepository.save(usuario);

        return ResponseEntity.ok().body("{\"value\": \"Senha alterada com sucesso!\"}");
    }
}