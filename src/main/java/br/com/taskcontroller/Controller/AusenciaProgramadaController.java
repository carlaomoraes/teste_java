package br.com.taskcontroller.Controller;

import br.com.taskcontroller.DTO.AusenciaProgramadaRequestDTO;
import br.com.taskcontroller.DTO.AusenciaProgramadaResponseDTO;
import br.com.taskcontroller.DTO.COMBO.AusenciaComboDTO;
import br.com.taskcontroller.Mapper.AusenciaProgramadaMapper;
import br.com.taskcontroller.Modelo.AusenciaProgramada;
import br.com.taskcontroller.Record.Ausencia.AusenciaListagemDTO;
import br.com.taskcontroller.Service.AusenciaProgramadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<AusenciaListagemDTO>> listarPorUsuario(@PathVariable Long idUsuario) {
        List<AusenciaListagemDTO> lista = service.listarPorUsuario(idUsuario);
        return ResponseEntity.ok(lista);
    }

    //MONTA COMBO TIPO DE AUSENCIA
    @GetMapping("/montaCombo")
    public List<AusenciaComboDTO> montaComboAusenciaCombo() {
        return service.montaComboAusencia();
    }


}