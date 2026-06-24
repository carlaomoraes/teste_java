package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.DTO.AusenciaProgramadaRequestDTO;
import br.com.taskboard.demo.DTO.AusenciaProgramadaResponseDTO;
import br.com.taskboard.demo.Mapper.AusenciaProgramadaMapper;
import br.com.taskboard.demo.Modelo.AusenciaProgramada;
import br.com.taskboard.demo.Service.AusenciaProgramadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ausencias")
public class AusenciaProgramadaController {

    @Autowired
    private AusenciaProgramadaService service;

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public AusenciaProgramadaResponseDTO buscarPorId(@PathVariable Long id) {
        return AusenciaProgramadaMapper.toDTO(service.buscarPorId(id));
    }

    // SALVAR
    @PostMapping("/salvar")
    public AusenciaProgramadaResponseDTO salvar(@RequestBody AusenciaProgramadaRequestDTO dto) {
        AusenciaProgramada ausenciaProgramada = AusenciaProgramadaMapper.toEntity(dto);
        return AusenciaProgramadaMapper.toDTO(service.salvar(ausenciaProgramada));
    }
    // ATUALIZAR
    @PutMapping("/atualizar/{idAusenciaProgramada}")
    public AusenciaProgramadaResponseDTO atualizar(@PathVariable Long idAusenciaProgramada,
                             @RequestBody AusenciaProgramadaRequestDTO dto) {
        AusenciaProgramada ausenciaProgramada = service.atualizar(idAusenciaProgramada, AusenciaProgramadaMapper.toEntity(dto));
        return AusenciaProgramadaMapper.toDTO(ausenciaProgramada);
    }

    // LISTAR
    @GetMapping("/listar")
    public List<AusenciaProgramadaResponseDTO> listar() {
        return service.listar().stream().map(AusenciaProgramadaMapper::toDTO).toList();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idAusenciaProgramada}")
    public ResponseEntity<Void> excluir(@PathVariable Long idAusenciaProgramada) {
        service.excluir(idAusenciaProgramada);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<AusenciaProgramada>> listarPorUsuario(@PathVariable Long idUsuario) {
        List<AusenciaProgramada> lista = service.listarPorUsuario(idUsuario);
        return ResponseEntity.ok(lista);
    }
}