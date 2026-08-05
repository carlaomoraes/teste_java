package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Modelo.Tarefa;;
import br.com.taskcontroller.Record.EstoriaConsultaDTO;
import br.com.taskcontroller.Record.TarefaConsultaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    boolean existsByEstoriaAndAtivaTrue(Estoria estoria);

    List<Tarefa> findByEstoria_Idestoria(Long idEstoria);

    @Query("""
            SELECT new br.com.taskcontroller.Record.TarefaConsultaDTO(
        e.idestoria,
        e.descestoria,
        e.status.idstatus,
        s.descstatus,
        r.idusuario,
        r.nome,
        c.idusuario,
        c.nome,
        e.resumo,
        COALESCE(e.pontos,0),
        COALESCE(e.horas_estimadas,0),
        COALESCE(e.horas_realizadas,0),
        e.data_inicio,
        e.data_fim,
        e.bloqueada)
    FROM Estoria e
            JOIN e.status s
            join e.responsavel r
            join e.criador c
           WHERE e.idestoria = :idestoria
             and e.epico.idepico = :idepico
          """)
    TarefaConsultaDTO buscarPorId(@Param("idetarefa") Long idtarefa, @Param("idepico") Long idepico);

    @Query("""
            SELECT new br.com.taskcontroller.Record.TarefaConsultaDTO(
                        idtarefa,
                        idestoria,
                        idstatus,
                        descstatus,
                        desctarefa,
                        idcriador,
                        nomecriador,
                        idresponsavel,
                        nomeresponsavel,
                        horas_estimadas,
                        horas_realizadas,
                        idtipo_tarefa,
                        bloqueada,
                        data_fim_prevista,
                        data_conclusao,
                        data_inicio,
                        ativa)
    FROM Estoria t
            JOIN t.status s
            join t.responsavel r
            join t.criador c
           WHERE t.idestoria = :idestoria
          """)
    List<TarefaConsultaDTO> buscarTarefaPorEstoria(@Param("idestoria") Long idestoria);

}
