package br.com.taskcontroller.Controller;

import br.com.taskcontroller.DTO.EquipeRequestDTO;
import br.com.taskcontroller.Mapper.EquipeMapper;
import br.com.taskcontroller.Modelo.Equipe;
import br.com.taskcontroller.Modelo.EquipeUsuario;
import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Record.Equipe.EquipeUsuarioDTO;
import br.com.taskcontroller.Respository.EquipeRepository;
import br.com.taskcontroller.Respository.EquipeUsuarioRepository;
import br.com.taskcontroller.Respository.UsuarioRepository;
import br.com.taskcontroller.Service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
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
            return ResponseEntity.ok(equipe);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Equipe não encontrada");
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<Equipe> salvar(@RequestBody EquipeRequestDTO dto) {
        Equipe equipe = EquipeMapper.toEntity(dto);
        return ResponseEntity.ok(service.salvar(equipe));
    }

    // ATUALIZAR (CORRIGIDO PATH VARIABLE)
    @PutMapping("/atualizar/{idequipe}")
    public ResponseEntity<Equipe> atualizar(
            @PathVariable("idequipe") Long idEquipe,
            @RequestBody Equipe equipe) {

        equipe.setIdequipe(idEquipe);
        return ResponseEntity.ok(service.atualizar(equipe));
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Equipe> listar() {

        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idequipe}")
    public ResponseEntity<String> excluir(@PathVariable Long idequipe) {
        service.excluir(idequipe);
        return ResponseEntity.ok().body("Equipe excluído com sucesso");
    }

    // =========================
    // MEMBROS DA EQUIPE
    // =========================
    @PostMapping("/{idEquipe}/membros/{idUsuario}")
    public ResponseEntity<?> adicionarMembro(
            @PathVariable Long idEquipe,
            @PathVariable Long idUsuario) {

        Equipe equipe = equipeRepository.findById(idEquipe)
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        EquipeUsuario equipeUsuario = new EquipeUsuario();
        equipeUsuario.setEquipe(equipe);
        equipeUsuario.setUsuario(usuario);

        equipeUsuarioRepository.save(equipeUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // LISTAR MEMBROS (ENTIDADE RELACIONAL)
    @GetMapping("/{idEquipe}/membros")
    public List<EquipeUsuarioDTO> listarMembros(@PathVariable Long idEquipe) {
        return equipeUsuarioRepository.listarMembros(idEquipe);
    }

    // LISTAR USUÁRIOS DA EQUIPE
    @GetMapping("/{idEquipe}/usuarios")
    public List<EquipeUsuarioDTO> listarUsuariosEquipe(@PathVariable Long idEquipe) {
        return equipeUsuarioRepository.buscarUsuariosPorEquipe(idEquipe);
    }

    // USUÁRIOS DISPONÍVEIS
    @GetMapping("/{idEquipe}/usuarios/disponiveis")
    public List<EquipeUsuarioDTO> listarUsuariosDisponiveis(@PathVariable Long idEquipe) {
        return equipeUsuarioRepository.buscarUsuariosDisponiveis(idEquipe);
    }

    // REMOVER MEMBRO (CORRIGIDO E SIMPLIFICADO)
    @DeleteMapping("/{idEquipe}/membros/{idUsuario}")
    public ResponseEntity<?> removerMembro(
            @PathVariable Long idEquipe,
            @PathVariable Long idUsuario) {

        equipeUsuarioRepository.removerMembro(idEquipe, idUsuario);

        return ResponseEntity.noContent().build();
    }
}