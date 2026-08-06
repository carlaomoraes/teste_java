package br.com.taskcontroller.Controller;

import br.com.taskcontroller.DTO.COMBO.PapelComboDTO;
import br.com.taskcontroller.Modelo.Papel;
import br.com.taskcontroller.Respository.PapelRepository;
import br.com.taskcontroller.Service.PapelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // SALVAR
    @PostMapping("/salvar")
    public Papel salvar(@RequestBody Papel Papel) {
        return service.salvar(Papel);
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idPapel}")
    public Papel atualizar(@PathVariable Long idPapel,
                             @RequestBody Papel Papel) {

        Papel.setIdpapel(idPapel);

        return service.atualizar(Papel);
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Papel> listar() {
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

