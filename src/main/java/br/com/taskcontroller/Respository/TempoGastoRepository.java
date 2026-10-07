package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.TempoGasto;
import br.com.taskcontroller.Record.TempoGasto.TempoGastoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TempoGastoRepository extends JpaRepository<TempoGasto, Long> {
    @Query("""
    SELECT new br.com.taskcontroller.Record.TempoGasto.TempoGastoDTO(
        tg.idtempogasto,
        tg.tarefa.idtarefa,
        t.desctarefa,
        tg.usuario.idusuario,
        u.nome,
        tg.data_execucao,
        tg.hora_execucao
    )
    FROM TempoGasto tg
    JOIN tg.tarefa t
    JOIN tg.usuario u
   WHERE tg.tarefa.idtarefa = :idTarefa
    ORDER BY tg.idtempogasto
    """)
    List<TempoGastoDTO> listarTempoGasto(@Param("idTarefa") Long idTarefa);
}
