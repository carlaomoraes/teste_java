package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // BUSCAR POR ID
    @GetMapping("/{idusuario}")
    public Usuario buscarPorId(@PathVariable Long idusuario) {
        return service.buscarPorId(idusuario);
    }

    // SALVAR
    @PostMapping("/salvar")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idusuario}")
    public Usuario atualizar(@PathVariable Long idusuario,
                             @RequestBody Usuario usuario) {

        usuario.setIdusuario(idusuario);

        return service.atualizar(usuario);
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

        return ResponseEntity.ok("Usuário excluído com sucesso");
    }
}