package br.com.taskcontroller.Controller;

import br.com.taskcontroller.DTO.StatusTransicaoRequestDTO;
import br.com.taskcontroller.Mapper.StatusTransicaoMapper;
import br.com.taskcontroller.Modelo.StatusTransicao;
import br.com.taskcontroller.Record.Status.StatusTransicaoListagemDTO;
import br.com.taskcontroller.Service.StatusTransicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status_transicao")
@RequiredArgsConstructor
public class StatusTransicaoController {

    private final StatusTransicaoService service;
    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody StatusTransicaoRequestDTO dto) {
        StatusTransicao status = StatusTransicaoMapper.toEntity(dto);
        return ResponseEntity.ok(service.salvar(status));
    }

    // LISTAR
    @GetMapping("/listar/{idTipoEntidade}")
    public List<StatusTransicaoListagemDTO> listar(@PathVariable Long idTipoEntidade) {
        return service.listarWorkFlow(idTipoEntidade);
    }
    // EXCLUIR
    @DeleteMapping("/excluir/{idTransicao}")
    public ResponseEntity<String> excluir(@PathVariable Long idTransicao) {
        service.excluir(idTransicao);
        return ResponseEntity.ok().body("Workflow excluído com sucesso");
    }
}