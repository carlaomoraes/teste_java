package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Empreendimento;
import br.com.taskboard.demo.Respository.EmpreendimentoRepository;
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
    @Autowired
    private EmpreendimentoRepository EmpreendimentoRepository;

    // BUSCAR POR ID
    @GetMapping("/{idEmpreendimento}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idEmpreendimento) {
        try {
            Empreendimento Empreendimento = service.buscarPorId(idEmpreendimento);
            return ResponseEntity.ok().body(Empreendimento);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Empreendimento não encontrado");
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public Empreendimento salvar(@RequestBody Empreendimento novoEmpreendimento) {
        if (novoEmpreendimento.getIdempreendimento() == null) {
            return service.salvar(novoEmpreendimento);
        } else { // Atualiza registro
            Empreendimento EmpreendimentoExistente = service.buscarPorId(novoEmpreendimento.getIdempreendimento());
            if (EmpreendimentoExistente != null) {
                EmpreendimentoExistente.setIdempreendimento(novoEmpreendimento.getIdempreendimento());
                EmpreendimentoExistente.setDescempreendimento(novoEmpreendimento.getDescempreendimento());
                EmpreendimentoExistente.setData_inicio(novoEmpreendimento.getData_inicio());
                EmpreendimentoExistente.setData_fim(novoEmpreendimento.getData_fim());
                EmpreendimentoExistente.setSiglaempreendimento(novoEmpreendimento.getSiglaempreendimento());
                EmpreendimentoExistente.setData_cadastro(novoEmpreendimento.getData_cadastro());
                EmpreendimentoExistente.setIdstatus(novoEmpreendimento.getIdstatus());
                EmpreendimentoExistente.setIdgestor(novoEmpreendimento.getIdgestor());
                return service.salvar(EmpreendimentoExistente);
            } else {
                return service.salvar(EmpreendimentoExistente);
            }
        }
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idEmpreendimento}")
    public Empreendimento atualizar(@PathVariable Long idEmpreendimento,
                             @RequestBody Empreendimento Empreendimento) {
        Empreendimento.setIdempreendimento(idEmpreendimento);
        return service.atualizar(Empreendimento);
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Empreendimento> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idEmpreendimento}")
    public ResponseEntity<String> excluir(@PathVariable Long idEmpreendimento) {
        service.excluir(idEmpreendimento);
        return ResponseEntity.ok().body("Épico excluído com sucesso");
    }
}