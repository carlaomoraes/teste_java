package br.com.taskcontroller.Controller;


import br.com.taskcontroller.DTO.TempoGastoRequestDTO;
import br.com.taskcontroller.Mapper.TempoGastoMapper;
import br.com.taskcontroller.Modelo.Sistema;
import br.com.taskcontroller.Modelo.Tarefa;
import br.com.taskcontroller.Modelo.TempoGasto;
import br.com.taskcontroller.Record.TempoGasto.TempoGastoDTO;
import br.com.taskcontroller.Respository.TempoGastoRepository;
import br.com.taskcontroller.Service.TarefaService;
import br.com.taskcontroller.Service.TempoGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/tempogasto")
public class TempoGastoController {

    @Autowired
    private TempoGastoRepository tempoGastoRepository;

    private final TempoGastoService service;

    private final TarefaService tarefaService;

    public TempoGastoController(TempoGastoService service, TarefaService tarefaService) {
        this.service = service;
        this.tarefaService = tarefaService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody TempoGastoRequestDTO dto) {
        Tarefa tarefa = tarefaService.buscarPorId(dto.getIdtarefa());
        BigDecimal horas_realizadas = service.transformarHoras(dto.getHora_execucao());
        tarefa.setHoras_realizadas(horas_realizadas);

        TempoGasto tempoGasto = TempoGastoMapper.toEntity(dto);

        return ResponseEntity.ok(service.salvar(tempoGasto));
    }

    // LISTAR
    @GetMapping("/listar/{idTarefa}")
    public List<TempoGastoDTO> listar(@PathVariable Long idTarefa) {
        return service.listar(idTarefa);
    }
    //EXCLUIR
    @DeleteMapping("/{idTempoGasto}")
    public ResponseEntity<Void> excluir(@PathVariable Long idTempoGasto) {

        service.excluir(idTempoGasto);

        return ResponseEntity.noContent().build();
    }

}