package br.com.taskcontroller.Controller;

import br.com.taskcontroller.DTO.PapelRequestDTO;
import br.com.taskcontroller.Mapper.PapelMapper;
import br.com.taskcontroller.Mapper.UsuarioMapper;
import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Record.Papel.PapelComboDTO;
import br.com.taskcontroller.Modelo.Papel;
import br.com.taskcontroller.Record.Papel.PapelListagemDTO;
import br.com.taskcontroller.Respository.PapelRepository;
import br.com.taskcontroller.Service.PapelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
@RequestMapping("/papel")
public class PapelController {

    @Autowired
    private PapelService service;
    @Autowired
    private PapelRepository papelRepository;

    // BUSCAR POR ID
    @GetMapping("/{idPapel}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idPapel) {
        try {
            Papel Papel = service.buscarPorId(idPapel);
            return ResponseEntity.ok().body(Papel);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Papel não encontrado");
        }
    }

    // BUSCAR POR ID
    @GetMapping("/DTO/{idPapel}")
    public PapelListagemDTO buscarID(@PathVariable Long idPapel) {
        return service.buscaPorIDDTO(idPapel);
    }

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody PapelRequestDTO dto) {
        System.out.println("ENTROU NO SALVAR PAPEL");
        System.out.println(dto);

        Papel papel = PapelMapper.toEntity(dto);
        return ResponseEntity.ok().body(service.salvar(papel));
    }

    // LISTAR
    @GetMapping("/listar")
    public List<PapelListagemDTO> listar() {

        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idPapel}")
    public ResponseEntity<String> excluir(@PathVariable Long idPapel) {
        service.excluir(idPapel);
        return ResponseEntity.ok().body("Papel excluído com sucesso");
    }

    // LISTAR
    @GetMapping("/montacomboPapel")
    public List<PapelComboDTO> mostrarComboPapel() {
        return service.montaComboPapel();
    }

}

