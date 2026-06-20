package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.DTO.EquipeUsuarioDTO;
import br.com.taskboard.demo.Modelo.Equipe;
import br.com.taskboard.demo.Modelo.EquipeUsuario;
import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.EquipeRepository;
import br.com.taskboard.demo.Respository.EquipeUsuarioRepository;
import br.com.taskboard.demo.Respository.UsuarioRepository;
import br.com.taskboard.demo.Service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EquipeUsuarioRepository equipeUsuarioRepository;

    @Autowired
    private EquipeService service;

    // BUSCAR POR ID
    @GetMapping("/{idequipe}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idequipe) {
        try {
            Equipe equipe = service.buscarPorId(idequipe);
            return ResponseEntity.ok().body(equipe);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Equipe não encontrada");
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public Equipe salvar(@RequestBody Equipe equipe) {
        if (equipe.getIdequipe() == null) {
            return service.salvar(equipe);
        } else {
            Equipe equipeExistente = service.buscarPorId(equipe.getIdequipe());
            if (equipeExistente != null) {
                equipeExistente.setIdequipe(equipe.getIdequipe());
                equipeExistente.setDescequipe(equipe.getDescequipe());
                equipeExistente.setNomeequipe(equipe.getNomeequipe());
                return service.salvar(equipeExistente);
            } else {
                return service.salvar(equipe);
            }
        }
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idequipe}")
    public Equipe atualizar(@PathVariable Long idEquipe,
                             @RequestBody Equipe equipe) {
        equipe.setIdequipe(idEquipe);
        return service.atualizar(equipe);
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Equipe> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idequipe}")
    public ResponseEntity<String> excluir(@PathVariable Long idequipe) {
        String Messagem = String.format("Não é possível excluir este %s pois ele está vinculado %s.",Long.toString(idequipe),"Sprint");
        try {
            service.excluir(idequipe);
            return ResponseEntity.ok().body("Equipe excluída com sucesso!");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.ok().body(Messagem);
        }
    }
    @PostMapping("/{idEquipe}/adicionarmembros")
    public ResponseEntity<?> adicionarMembro(
            @PathVariable Long idEquipe,
            @RequestBody EquipeUsuarioDTO dto) {

        Equipe equipe = equipeRepository
                .findById(idEquipe)
                .orElseThrow();

        Usuario usuario = usuarioRepository
                .findById(dto.getIdusuario())
                .orElseThrow();

        EquipeUsuario equipeUsuario =
                new EquipeUsuario();

        equipeUsuario.setEquipe(equipe);
        equipeUsuario.setUsuario(usuario);

        equipeUsuarioRepository.save(equipeUsuario);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idEquipe}/membros")
    public List<EquipeUsuario> listarMembros(
            @PathVariable Long idEquipe){

        return equipeUsuarioRepository.listarMembros(idEquipe);
    }
    @DeleteMapping("/{idEquipe}/membros/{idUsuario}")
    public ResponseEntity<?> removerMembro(
            @PathVariable Long idEquipe,
            @PathVariable Long idUsuario) {

        equipeUsuarioRepository.removerMembro(
                idEquipe,
                idUsuario);

        return ResponseEntity.ok().build();
    }
}