package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.Configuracao;
import br.com.taskcontroller.Respository.ConfiguracaoRepository;
import br.com.taskcontroller.Respository.EmpreendimentoRepository;
import br.com.taskcontroller.Service.ConfiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuracao")
public class ConfiguracaoController {

    @Autowired
    private ConfiguracaoService service;

    @Autowired
    private ConfiguracaoRepository ConfiguracaoRepository;

    @Autowired
    private EmpreendimentoRepository empreendimentoRepository;


    // BUSCAR POR ID
    @GetMapping("/{idConfiguracao}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idConfiguracao) {
        try {
            Configuracao Configuracao = service.buscarPorId(idConfiguracao);
            return ResponseEntity.ok().body(Configuracao);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Configuracao não encontrada");
        }
    }
    //BUSCA CONFIGURAÇÃO POR EMPREENDIMENTO
    @GetMapping("/empreendimento/{idEmpreendimento}")
    public ResponseEntity<?> buscarPorIdEmpreendimento(@PathVariable Long idEmpreendimento) {
        Empreendimento empreendimento = empreendimentoRepository.findById(idEmpreendimento).get();
        try {
            Configuracao Configuracao = service.buscarPorEmpreendimento(empreendimento);
            return ResponseEntity.ok().body(Configuracao);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Configuracao não encontrada");
        }
    }


    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody Configuracao configuracao) {
        // 1. Valida se o Empreendimento existe
        Empreendimento empreendimento = empreendimentoRepository.findById(configuracao.getEmpreendimento().getIdempreendimento()).orElse(null);
        if(empreendimento == null) {
            throw new RuntimeException("Empreendimento não encontrado!");
        }
        configuracao.setEmpreendimento(empreendimento);

        // 2. Salva a Configuracao
        return ResponseEntity.ok(ConfiguracaoRepository.save(configuracao));
    }
    // LISTAR
    @GetMapping("/listar")
    public List<Configuracao> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idConfiguracao}")
    public ResponseEntity<String> excluir(@PathVariable Long idConfiguracao) {
        try {
            service.excluir(idConfiguracao);
            return ResponseEntity.ok().body("Configuração excluída com sucesso!");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.ok().body("Não foi possível excluir a configuracao!");
        }
    }
}