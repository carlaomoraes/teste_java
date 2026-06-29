package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Empreendimento;
import br.com.taskboard.demo.Modelo.EmpreendimentoEquipe;
import br.com.taskboard.demo.Modelo.Equipe;
import br.com.taskboard.demo.Respository.EmpreendimentoRepository;
import br.com.taskboard.demo.Respository.EquipeEmpreendimentoRepository;
import br.com.taskboard.demo.Respository.EquipeRepository;
import br.com.taskboard.demo.Service.EmpreendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empreendimento")
public class EmpreendimentoController {

    @Autowired
    private EmpreendimentoService service;

    //==========================
    // CRUD
    //==========================

    @GetMapping("/{idEmpreendimento}")
    public ResponseEntity<Empreendimento> buscarPorId(
            @PathVariable Long idEmpreendimento) {

        return ResponseEntity.ok(service.buscarPorId(idEmpreendimento));
    }

    @GetMapping("/listar")
    public List<Empreendimento> listar() {
        return service.listar();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Empreendimento> salvar(
            @RequestBody Empreendimento empreendimento) {

        return ResponseEntity.ok(service.salvar(empreendimento));
    }

    @PutMapping("/{idEmpreendimento}")
    public ResponseEntity<Empreendimento> atualizar(
            @PathVariable Long idEmpreendimento,
            @RequestBody Empreendimento empreendimento) {

        empreendimento.setIdempreendimento(idEmpreendimento);

        return ResponseEntity.ok(service.atualizar(empreendimento));
    }

    @DeleteMapping("/{idEmpreendimento}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long idEmpreendimento) {

        service.excluir(idEmpreendimento);

        return ResponseEntity.noContent().build();
    }

    //==========================
    // EQUIPES
    //==========================

    @PostMapping("/{idEmpreendimento}/equipes/{idEquipe}")
    public ResponseEntity<Void> adicionarEquipe(
            @PathVariable Long idEmpreendimento,
            @PathVariable Long idEquipe) {

        service.adicionarEquipe(idEmpreendimento, idEquipe);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{idEmpreendimento}/equipes/{idEquipe}")
    public ResponseEntity<Void> removerEquipe(
            @PathVariable Long idEmpreendimento,
            @PathVariable Long idEquipe) {

        service.removerEquipe(idEmpreendimento, idEquipe);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idEmpreendimento}/equipes")
    public List<Equipe> listarEquipes(
            @PathVariable Long idEmpreendimento) {

        return service.listarEquipes(idEmpreendimento);
    }

    @GetMapping("/{idEmpreendimento}/equipes/disponiveis")
    public List<Equipe> listarEquipesDisponiveis(
            @PathVariable Long idEmpreendimento) {

        return service.listarEquipesDisponiveis(idEmpreendimento);
    }
}