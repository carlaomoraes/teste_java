package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.TempoGasto;
import br.com.taskcontroller.Record.TempoGasto.TempoGastoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TempoGastoRepository extends JpaRepository<TempoGasto, Long> {
    @Query("""
    SELECT new br.com.taskcontroller.Record.TempoGasto.TempoGastoDTO(
        tg.idtempo_gasto,
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
    ORDER BY tg.idtempo_gasto
    """)
    List<TempoGastoDTO> listarTempoGasto(@Param("idTarefa") Long idTarefa);

    @Query("""
    SELECT COALESCE(sum(tg.hora_execucao),0)
      FROM TempoGasto tg
    WHERE tg.tarefa.idtarefa = :idTarefa
    """)
    int totalizarTarefa(@Param("idTarefa") Long idTarefa);

}
