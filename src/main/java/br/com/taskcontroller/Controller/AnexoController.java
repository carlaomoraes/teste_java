package br.com.taskcontroller.Controller;

import br.com.taskcontroller.DTO.AnexoRequestDTO;
import br.com.taskcontroller.DTO.AnexoResponseDTO;
import br.com.taskcontroller.Mapper.AnexoMapper;
import br.com.taskcontroller.Mapper.EpicoMapper;
import br.com.taskcontroller.Modelo.Anexo;
import br.com.taskcontroller.Modelo.Epico;
import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Respository.AnexoRepository;
import br.com.taskcontroller.Respository.EpicoRepository;
import br.com.taskcontroller.Respository.UsuarioRepository;
import br.com.taskcontroller.Service.AnexoService;
import br.com.taskcontroller.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anexo")
public class AnexoController {

    @Autowired
    private AnexoService service;

    @Autowired
    private AnexoRepository  repository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EpicoRepository epicoRepository;

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody AnexoRequestDTO dto) {
        Anexo anexo = AnexoMapper.toEntity(dto);
        Usuario responsavel = usuarioRepository.findById(dto.getUsuario().getIdusuario())
                .orElseThrow(() -> new RuntimeException("Usuário responsavel não encontrado"));
        anexo.setUsuario(responsavel);
        Epico epico = epicoRepository.findById(dto.getEpico().getIdepico()).orElseThrow(() -> new RuntimeException("Épico não encontrado"));
        anexo.setEpico(epico);
        repository.save(anexo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    // LISTAR
    @GetMapping("/listar/{idEpico}")
    public List<Anexo> listar(@PathVariable Long idEpico) {
        return service.listarPorEpico(idEpico);
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idAnexo}")
    public ResponseEntity<Void> excluir(@PathVariable Long idAnexo) {
        service.excluir(idAnexo);
        return ResponseEntity.noContent().build();
    }
}