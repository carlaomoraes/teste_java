package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Tarefa;
import br.com.taskcontroller.Modelo.TempoGasto;
import br.com.taskcontroller.Record.TempoGasto.TempoGastoDTO;
import br.com.taskcontroller.Respository.StatusEntidadesRepository;
import br.com.taskcontroller.Respository.TarefaRepository;
import br.com.taskcontroller.Respository.TempoGastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public TempoGasto salvar(TempoGasto tempoGasto) {
        Tarefa tarefa = tarefaService.buscarPorId(tempoGasto.getTarefa().getIdtarefa());
        BigDecimal horas = transformarHoras(tempoGasto.getHora_execucao());
        BigDecimal total = tarefa.getHoras_realizadas().add(horas);
        tarefa.setHoras_realizadas(total);
        tarefaService.salvar(tarefa);

        return repository.save(tempoGasto);
    }

    public List<TempoGastoDTO> listar(@Param("idTarefa") Long idTarefa) {

        return repository.listarTempoGasto(idTarefa);
    }

    public TempoGasto atualizar(TempoGasto tempoGasto) {
        Tarefa tarefa = tempoGasto.getTarefa();
        BigDecimal horas = transformarHoras(tempoGasto.getHora_execucao());
        BigDecimal total = tarefa.getHoras_realizadas().subtract(horas);
        tarefa.setHoras_realizadas(total);
        return repository.save(tempoGasto);
    }


    public TempoGasto buscarPorId(Long idTempoGasto) {
        return repository.findById(idTempoGasto).orElseThrow(() -> new RuntimeException("TempoGasto não encontrado"));
    }

    public BigDecimal transformarHoras(LocalTime horas) {
        if (horas == null) {
            return BigDecimal.ZERO;
        }
        int h = horas.getHour();
        int m = horas.getMinute();
        int s = horas.getSecond();

        BigDecimal horasDecimais = BigDecimal.valueOf(h)
                .add(BigDecimal.valueOf(m)
                        .divide(BigDecimal.valueOf(60), 4, RoundingMode.HALF_UP))
                .add(BigDecimal.valueOf(s)
                        .divide(BigDecimal.valueOf(3600), 4, RoundingMode.HALF_UP));

        return horasDecimais.setScale(2, RoundingMode.HALF_UP);
    }

    @Transactional
    public void excluir(Long idTempoGasto) {

        TempoGasto tempoGasto = buscarPorId(idTempoGasto);

        Tarefa tarefa = tempoGasto.getTarefa();

        BigDecimal horas = transformarHoras(
                tempoGasto.getHora_execucao()
        );

        BigDecimal total = tarefa.getHoras_realizadas()
                .subtract(horas);

        tarefa.setHoras_realizadas(total);

        tarefaRepository.save(tarefa);

        repository.delete(tempoGasto);
    }
}