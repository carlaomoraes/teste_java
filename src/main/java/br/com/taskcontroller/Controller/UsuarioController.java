package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.Papel;
import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Service.EmpreendimentoService;
import br.com.taskcontroller.Service.PapelService;
import br.com.taskcontroller.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UsuarioService service;

    @Autowired
    private PapelService papelService;

    @Autowired
    private EmpreendimentoService empreendimentoService;


    // BUSCAR POR ID
    @GetMapping("/{idusuario}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idusuario) {
        Usuario usuario = service.buscarPorId(idusuario);
        return ResponseEntity.ok().body(usuario);
    }

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody Usuario novoUsuario) {
        // 1. Busca o papel do banco de dados primeiro
        Papel papel = papelService.buscarPorId(novoUsuario.getPapel().getIdpapel());
        if (papel == null) {
            return ResponseEntity.badRequest().body("Erro: O papel do usuário deve ser informado.");
        }
        // 2. Busca empreendimento
        Empreendimento  empreendimento = empreendimentoService.buscarPorId(novoUsuario.getEmpreendimento().getIdempreendimento());
        if (empreendimento == null) {
            return ResponseEntity.badRequest().body("Erro: O empreendimento padrão deve ser informado.");
        }
        if (novoUsuario.getIdusuario() == null) {
            // CRIAÇÃO: Cria um novo objeto Usuario gerenciado corretamente
            Usuario usuarioParaSalvar = new Usuario();
            usuarioParaSalvar.setNome(novoUsuario.getNome());
            usuarioParaSalvar.setEmail(novoUsuario.getEmail());
            usuarioParaSalvar.setLogin(novoUsuario.getLogin());
            usuarioParaSalvar.setAlterasenha(novoUsuario.isAlterasenha());

            // Criptografa a senha
            String senhaCriptografada = encoder.encode(novoUsuario.getSenha());
            usuarioParaSalvar.setSenha(senhaCriptografada);

            // Associa o papel persistido do banco
            usuarioParaSalvar.setPapel(papel);

            // Associa o empreendimento padrão
            usuarioParaSalvar.setEmpreendimento(empreendimento);

            return ResponseEntity.ok().body(service.salvar(usuarioParaSalvar));

        } else {
            // ATUALIZAÇÃO: Busca o usuário existente no banco
            Usuario usuarioExistente = service.buscarPorId(novoUsuario.getIdusuario());

            if (usuarioExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
            }

            usuarioExistente.setNome(novoUsuario.getNome());
            usuarioExistente.setEmail(novoUsuario.getEmail());
            usuarioExistente.setLogin(novoUsuario.getLogin());
            usuarioExistente.setAlterasenha(novoUsuario.isAlterasenha());
            usuarioExistente.setPapel(papel); // Associa o papel persistido do banco
            usuarioExistente.setEmpreendimento(empreendimento);

            // Regra para senha na atualização (Criptografa apenas se ela mudou)
            if (novoUsuario.getSenha() != null && !novoUsuario.getSenha().isEmpty()) {
                String novaSenhaCriptografada = encoder.encode(novoUsuario.getSenha());
                usuarioExistente.setSenha(novaSenhaCriptografada);
            }

            return ResponseEntity.ok().body(service.salvar(usuarioExistente));
        }
    }
    // ATUALIZAR
    @PutMapping("/atualizar/{idusuario}")
    public ResponseEntity<?> atualizar(@PathVariable Long idusuario,
                             @RequestBody Usuario usuario) {
        Papel papel = papelService.buscarPorId(usuario.getPapel().getIdpapel());
        if (papel == null) {
            return ResponseEntity.badRequest().body("Erro: O papel do usuário deve ser informado.");
        }
        usuario.setPapel(papel);
        Empreendimento  empreendimento = empreendimentoService.buscarPorId(usuario.getEmpreendimento().getIdempreendimento());
        if (empreendimento == null) {
            return ResponseEntity.badRequest().body("Erro: O empreendimento padrão deve ser informado.");
        }
        usuario.setEmpreendimento(empreendimento);
        return ResponseEntity.ok().body(service.atualizar(usuario));
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Usuario> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idusuario}")
    public ResponseEntity<String> excluir(@PathVariable Long idusuario) {
        service.excluir(idusuario);
        return ResponseEntity.ok().body("Usuário excluído com sucesso");
    }
}