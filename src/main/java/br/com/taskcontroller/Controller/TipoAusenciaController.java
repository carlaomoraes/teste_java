package br.com.taskcontroller.Controller;

import br.com.taskcontroller.DTO.TipoAusenciaRequestDTO;
import br.com.taskcontroller.DTO.UsuarioRequestDTO;
import br.com.taskcontroller.Mapper.Tipo_AusenciaMapper;
import br.com.taskcontroller.Mapper.UsuarioMapper;
import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Modelo.Tipo_Ausencia;
import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Respository.TipoAusenciaRepository;
import br.com.taskcontroller.Service.TipoAusenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_ausencias")
public class TipoAusenciaController {

    @Autowired
    private TipoAusenciaService service;
    @Autowired
    private TipoAusenciaRepository TipoAusenciaRepository;

    // BUSCAR POR ID
    @GetMapping("/{idTipoAusencia}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idTipoAusencia) {
        try {
            Tipo_Ausencia tipo_ausencia = service.buscarPorId(idTipoAusencia);
            return ResponseEntity.ok().body(tipo_ausencia);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Tipo de ausência não encontrado");
        }
    }
    // SALVAR
    @PostMapping("/salvar")
    public Tipo_Ausencia salvar(@RequestBody TipoAusenciaRequestDTO dto) {
        Tipo_Ausencia tipo_ausencia = Tipo_AusenciaMapper.toEntity(dto);
        return ResponseEntity.ok().body(service.salvar(tipo_ausencia)).getBody();
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Tipo_Ausencia> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idTipo_ausencia}")
    public ResponseEntity<String> excluir(@PathVariable Long idTipo_ausencia) {
        service.excluir(idTipo_ausencia);
        return ResponseEntity.ok().body("Tipo de ausência excluída com sucesso!");
    }
}