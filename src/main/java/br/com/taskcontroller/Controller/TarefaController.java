package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Mapper.TarefaMapper;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Tarefa.TarefaConsultaDTO;
import br.com.taskcontroller.Record.Tarefa.TarefaInclusaoDTO;
import br.com.taskcontroller.Respository.TarefaRepository;
import br.com.taskcontroller.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TarefaRepository tarefaRepository;

    // BUSCAR POR ID
    @GetMapping("/{idTarefa}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idTarefa) {
        try {
            Tarefa tarefa = service.buscarPorId(idTarefa);
            return ResponseEntity.ok().body(tarefa);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Tarefa não encontrada");
        }
    }
    // BUSCAR POR ID - DTO
    @GetMapping("/DTO/{idTarefa}")
    public TarefaConsultaDTO buscarPorIDDTO(@PathVariable Long idTarefa) {
        return service.buscaPorIDDTO(idTarefa);
    }

    // APAGAR UMA TAREFA
    @DeleteMapping("/remover_tarefa/{idTarefa}")
    public ResponseEntity<?> apagarTarefa(@PathVariable Long idTarefa) {
        tarefaRepository.apagarTarefa(idTarefa);
        return ResponseEntity.noContent().build();
    }

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<Tarefa> salvar_tarefa(@RequestBody TarefaInclusaoDTO dto) {
        Tarefa tarefa = TarefaMapper.toEntity(dto);
        return ResponseEntity.ok().body(service.salvar(tarefa));
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idTarefa}")
    public Tarefa atualizar(@PathVariable Long idTarefa, @RequestBody Tarefa tarefa)  {
        tarefa.setIdtarefa(idTarefa);
        service.alterarStatus(idTarefa, tarefa.getStatus().getIdstatus());
        return service.atualizar(tarefa);
    }


    // EXCLUIR
    @DeleteMapping("/excluir/{idTarefa}")
    public ResponseEntity<String> excluir(@PathVariable Long idTarefa) {
        service.excluir(idTarefa);
        return ResponseEntity.ok().body("Tarefa excluída com sucesso!");
    }
    // LISTAR TAREFAS POR ESTORIA
    @GetMapping("/{idEstoria}/tarefas")
    public List<TarefaConsultaDTO> listarPorEstoria(@PathVariable Long idEstoria) {
        return service.listarPorEstoria(idEstoria);
    }
}