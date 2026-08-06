package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.TarefaConsultaDTO;
import br.com.taskcontroller.Respository.EpicoEstoriasRepository;
import br.com.taskcontroller.Respository.TarefaRepository;
import br.com.taskcontroller.Respository.UsuarioRepository;
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

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<Tarefa> salvar(@RequestBody Tarefa tarefa) {
//        StatusEntidades statusEntidades = statusService.buscarPorId(tarefa.getStatus().getIdstatus());
//        if (statusEntidades == null) {
//            return ResponseEntity.notFound().build();
//        }
//        tarefa.setStatus(statusEntidades);
        Usuario criador = usuarioService.buscarPorId(tarefa.getCriador().getIdusuario());
        if (criador == null) {
            return ResponseEntity.notFound().build();
        }
        tarefa.setCriador(criador);
        Usuario responsavel = usuarioService.buscarPorId(tarefa.getResponsavel().getIdusuario());
        if (responsavel == null) {
            return ResponseEntity.notFound().build();
        }
        tarefa.setResponsavel(responsavel);
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