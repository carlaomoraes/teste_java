package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Modelo.Configuracao;
import br.com.taskcontroller.Service.ConfiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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