package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Configuracao;
import br.com.taskboard.demo.Service.ConfiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/configuracao")
public class ConfiguracaoController {
    @Autowired
    private ConfiguracaoService service;

    // BUSCAR POR ID
    @GetMapping("/buscaPorId/{idconfiguracao}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idconfiguracao) {
        Configuracao configuracao = service.buscarPorId(idconfiguracao);
        return ResponseEntity.ok().body(configuracao);
    }

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody Configuracao configuracao) {
            return ResponseEntity.ok().body(service.atualizar(configuracao));
    }
    // BUSCAR POR ID EMPREENDIMENTO
    @GetMapping("/buscaPorEmpreendimento/{idempreendimento}")
    public ResponseEntity<Configuracao> buscarPorEmpreendimento(
            @PathVariable Long idempreendimento) {
        return ResponseEntity.ok(service.buscarConfiguracaoPorEmpreendimento(idempreendimento));
    }


}