package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Mapper.TarefaMapper;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Tarefa.TarefaConsultaDTO;
import br.com.taskcontroller.Record.Tarefa.TarefaInclusaoDTO;
import br.com.taskcontroller.Respository.*;
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
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstoriaRepository estoriaRepository;

    @Autowired
    private TipoTarefaRepository tipoTarefaRepository;

    @Autowired
    private StatusEntidadesRepository statusEntidadesRepository;


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
        Tarefa tarefa;
        if(dto.idtarefa() == null) {
            tarefa = TarefaMapper.toEntity(dto);
        } else {
            tarefa = service.buscarPorId(dto.idtarefa());
            tarefa.setDesctarefa(dto.desctarefa());
            tarefa.setHoras_realizadas(dto.horas_realizadas());
            tarefa.setHoras_estimadas(dto.horas_estimadas());
            tarefa.setBloqueada(dto.bloqueada());
            tarefa.setData_fim_prevista(dto.data_fim_prevista());
            tarefa.setData_conclusao(dto.data_conclusao());
            tarefa.setData_inicio(dto.data_inicio());
        }
        Estoria estoria = estoriaRepository.findById(dto.idestoria()).orElseThrow();

        StatusEntidades status = statusEntidadesRepository.findById(dto.idstatus()).orElseThrow();

        Usuario criador = usuarioRepository.findById(dto.idcriador()).orElseThrow();

        Usuario responsavel = usuarioRepository.findById(dto.idresponsavel()).orElseThrow();

        TipoTarefa tipoTarefa = tipoTarefaRepository.findById(dto.idtipotarefa()).orElseThrow();

        tarefa.setEstoria(estoria);
        tarefa.setStatus(status);
        tarefa.setCriador(criador);
        tarefa.setResponsavel(responsavel);
        tarefa.setTipotarefa(tipoTarefa);

        return ResponseEntity.ok().body(service.salvar(tarefa));
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