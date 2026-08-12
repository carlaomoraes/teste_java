package br.com.taskcontroller.Controller;

import br.com.taskcontroller.DTO.UsuarioRequestDTO;
import br.com.taskcontroller.Mapper.UsuarioMapper;
import br.com.taskcontroller.Record.Usuario.UsuarioListagemDTO;
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

    // BUSCAR POR ID E RETORNA UM DTO PARA TELA
    @GetMapping("/DTO/{idusuario}")
    public ResponseEntity<?> buscarLinha(@PathVariable Long idusuario) {
        UsuarioListagemDTO usuario = service.buscarPorLinha(idusuario);
        return ResponseEntity.ok().body(usuario);
    }
    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody UsuarioRequestDTO  dto) {
        Usuario usuario = UsuarioMapper.toEntity(dto);
        // Criptografa a senha
        String senhaCriptografada = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return ResponseEntity.ok().body(service.salvar(usuario));
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
        return ResponseEntity.ok().body(service.atualizar(usuario));
    }

    // LISTAR
    @GetMapping("/listar")
    public List<UsuarioListagemDTO> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idusuario}")
    public ResponseEntity<String> excluir(@PathVariable Long idusuario) {
        service.excluir(idusuario);
        return ResponseEntity.ok().body("Usuário excluído com sucesso");
    }
}