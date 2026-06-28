package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Empreendimento;
import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // BUSCAR POR ID
    @GetMapping("/{idusuario}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idusuario) {
        Usuario usuario = service.buscarPorId(idusuario);
        return ResponseEntity.ok().body(usuario);
    }

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok().body(service.salvar(usuario));
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idusuario}")
    public ResponseEntity<?> atualizar(@PathVariable Long idusuario,
                             @RequestBody Usuario usuario) {
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