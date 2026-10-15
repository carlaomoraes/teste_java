package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Tarefa;
import br.com.taskcontroller.Modelo.TempoGasto;
import br.com.taskcontroller.Record.TempoGasto.TempoGastoDTO;
import br.com.taskcontroller.Respository.EstoriaRepository;
import br.com.taskcontroller.Respository.TarefaRepository;
import br.com.taskcontroller.Respository.TempoGastoRepository;
import br.com.taskcontroller.Utilidades.ResolveTempo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

@Service
public class TempoGastoService {

    @Autowired
    private TempoGastoRepository repository;

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaService tarefaService;

    @Transactional
    public TempoGasto salvar(TempoGasto tempoGasto) {
        ResolveTempo resolveTempo = new ResolveTempo();
        Tarefa tarefa = tarefaService.buscarPorId(tempoGasto.getTarefa().getIdtarefa());

        int total = resolveTempo.transformarToDecimal(tempoGasto.getHora_execucao());

        int banco = repository.totalizarTarefa(tempoGasto.getTarefa().getIdtarefa());
        int totalizar = total + banco;

        tarefa.setHoras_realizadas(totalizar);
        tarefaService.salvar(tarefa);
        return repository.save(tempoGasto);
    }
    public int totalizar(@Param("idTarefa") Long idTarefa) {
        return repository.totalizarTarefa(idTarefa);
    }

    public List<TempoGastoDTO> listar(@Param("idTarefa") Long idTarefa) {

        return repository.listarTempoGasto(idTarefa);
    }

    public TempoGasto atualizar(TempoGasto tempoGasto) {
        Tarefa tarefa = tempoGasto.getTarefa();
        ResolveTempo resolveTempo = new ResolveTempo();
        int horas = resolveTempo.transformarToDecimal(tempoGasto.getHora_execucao());
        int total = tarefa.getHoras_realizadas() -horas;
        tarefa.setHoras_realizadas(total);
        return repository.save(tempoGasto);
    }


    public TempoGasto buscarPorId(Long idTempoGasto) {
        return repository.findById(idTempoGasto).orElseThrow(() -> new RuntimeException("TempoGasto não encontrado"));
    }


    @Transactional
    public void excluir(Long idTempoGasto) {
        ResolveTempo resolveTempo = new ResolveTempo();

        TempoGasto tempoGasto = buscarPorId(idTempoGasto);

        Tarefa tarefa = tempoGasto.getTarefa();

        int horas = resolveTempo.transformarToDecimal(tempoGasto.getHora_execucao());

        int total = tarefa.getHoras_realizadas() - horas;

        tarefa.setHoras_realizadas(total);

        tarefaRepository.save(tarefa);

        repository.delete(tempoGasto);
    }
}