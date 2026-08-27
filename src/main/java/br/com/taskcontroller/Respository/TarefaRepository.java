package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Tarefa;
import br.com.taskcontroller.Record.Tarefa.TarefaConsultaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    @Query("""
            SELECT new br.com.taskcontroller.Record.Tarefa.TarefaConsultaDTO(
                t.idtarefa,
                t.estoria.idestoria,
                t.status.idstatus,
                s.descstatus,
                t.desctarefa,
                t.criador.idusuario,
                c.nome,
                t.responsavel.idusuario,
                r.nome,
                coalesce(t.horas_estimadas,0),
                coalesce(t.horas_realizadas,0),
                tt.idtipo_tarefa,
                tt.desctipo_tarefa,
                t.bloqueada,
                t.data_fim_prevista,
                t.data_conclusao,
                t.data_inicio
            )
            FROM Tarefa t
            JOIN t.status s
            join t.responsavel r
            join t.criador c
            join t.tipotarefa tt
           WHERE t.idtarefa = :idtarefa
    """)
    TarefaConsultaDTO buscarPorId(@Param("idtarefa") Long idtarefa);

    @Query("""
    SELECT new br.com.taskcontroller.Record.Tarefa.TarefaConsultaDTO(
        t.idtarefa,
        t.estoria.idestoria,
        t.status.idstatus,
        s.descstatus,
        t.desctarefa,
        t.criador.idusuario,
        c.nome,
        t.responsavel.idusuario,
        r.nome,
        coalesce(t.horas_estimadas,0),
        coalesce(t.horas_realizadas,0),
        tt.idtipo_tarefa,
        tt.desctipo_tarefa,
        t.bloqueada,
        t.data_fim_prevista,
        t.data_conclusao,
        t.data_inicio
    )
    FROM Tarefa t
    JOIN t.status s
    JOIN t.responsavel r
    JOIN t.criador c
    JOIN t.tipotarefa tt
    WHERE t.estoria.idestoria = :idestoria
""")
    List<TarefaConsultaDTO> buscarTarefaPorEstoria(@Param("idestoria") Long idestoria);

    @Modifying
    @Transactional
    @Query("""
        DELETE
          FROM Tarefa t
         WHERE t.idtarefa = :idTarefa
    """)
    void apagarTarefa(@Param("idTarefa") Long idTarefa);

}