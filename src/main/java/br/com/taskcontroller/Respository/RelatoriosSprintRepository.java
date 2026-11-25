package br.com.taskcontroller.Respository;

import br.com.taskcontroller.DTO.Relatorios.RelatorioHorasTarefaDTO;
import br.com.taskcontroller.Modelo.Sprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.taskcontroller.Record.Sprint.SprintListagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO;

import java.util.List;
import java.time.LocalDate;

public interface RelatoriosSprintRepository extends JpaRepository<Sprint, Long> {
    @Query("""
    SELECT new br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO(
                s.empreendimento.idempreendimento,
                s.empreendimento.descempreendimento,
                s.idsprint,
                s.descsprint,
                s.dtiniciosprint,
                s.dtfinalsprint,
                s.status.descstatus,
                s.status.cor,
                COUNT(DISTINCT(e.idestoria)),
                COUNT(DISTINCT(t.idtarefa)),
                SUM(COALESCE(t.horas_estimadas,0)),
                SUM(COALESCE(t.horas_realizadas,0)),
                "",
                "",
                0.00BD
    )
    FROM Sprint s
    JOIN SprintEstoria se on se.sprint.idsprint = s.idsprint
    JOIN se.estoria e
    LEFT JOIN Tarefa t on t.estoria.idestoria = e.idestoria
    WHERE s.empreendimento.idempreendimento = :idempreendimento
    GROUP BY
        s.empreendimento.idempreendimento,
        s.empreendimento.descempreendimento,
        s.idsprint,
        s.descsprint,
        s.dtiniciosprint,
        s.dtfinalsprint,
        s.status.descstatus,
        s.status.cor
    ORDER BY s.dtiniciosprint
""")
    List<RelatorioSprintDTO> relatorioSprintPorEmpreendimento(@Param("idempreendimento") Long idempreendimento);

    @Query("""
    SELECT new br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO(
                s.empreendimento.idempreendimento,
                s.empreendimento.descempreendimento,
                s.idsprint,
                s.descsprint,
                s.dtiniciosprint,
                s.dtfinalsprint,
                s.status.descstatus,
                s.status.cor,
                COUNT(DISTINCT(e.idestoria)),
                COUNT(DISTINCT(t.idtarefa)),
                SUM(COALESCE(t.horas_estimadas,0)),
                SUM(COALESCE(t.horas_realizadas,0)),
                "",
                "",
                0.00BD
    )
    FROM Sprint s
    JOIN SprintEstoria se on se.sprint.idsprint = s.idsprint
    JOIN se.estoria e
    LEFT JOIN Tarefa t on t.estoria.idestoria = e.idestoria
    WHERE s.idsprint in (:idSprint)
    GROUP BY
        s.empreendimento.idempreendimento,
        s.empreendimento.descempreendimento,
        s.idsprint,
        s.descsprint,
        s.dtiniciosprint,
        s.dtfinalsprint,
        s.status.descstatus,
        s.status.cor
    ORDER BY s.dtiniciosprint
""")
    List<RelatorioSprintDTO> relatorioSprintPorID(@Param("idSprint") List<Long> idSprint);

    @Query("""
    SELECT new br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO(
                s.empreendimento.idempreendimento,
                s.empreendimento.descempreendimento,
                s.idsprint,
                s.descsprint,
                s.dtiniciosprint,
                s.dtfinalsprint,
                s.status.descstatus,
                s.status.cor,
                COUNT(DISTINCT(e.idestoria)),
                COUNT(DISTINCT(t.idtarefa)),
                SUM(COALESCE(t.horas_estimadas,0)),
                SUM(COALESCE(t.horas_realizadas,0)),
                "",
                "",
                0.00BD
    )
    FROM Sprint s
    JOIN SprintEstoria se on se.sprint.idsprint = s.idsprint
    JOIN se.estoria e
    LEFT JOIN Tarefa t on t.estoria.idestoria = e.idestoria
    WHERE s.dtiniciosprint <= :data_final
      AND s.dtfinalsprint >= :data_inicial
    GROUP BY
        s.empreendimento.idempreendimento,
        s.empreendimento.descempreendimento,
        s.idsprint,
        s.descsprint,
        s.dtiniciosprint,
        s.dtfinalsprint,
        s.status.descstatus,
        s.status.cor
    ORDER BY s.dtiniciosprint
""")
    List<RelatorioSprintDTO> relatorioSprintPorPeriodo(@Param("data_inicial") LocalDate data_inicial,
                                                       @Param("data_final") LocalDate data_final);

    @Query("""
    select new br.com.taskcontroller.Record.Sprint.SprintListagemDTO(
            s.empreendimento.idempreendimento,
            s.idsprint,
            s.descsprint,
            s.dtiniciosprint,
            s.dtfinalsprint,
            s.visivel,
            s.status.idstatus,
            s.status.descstatus,
            s.status.cor,
            DATEDIFF(s.dtfinalsprint,s.dtiniciosprint))
    from Sprint s
    JOIN StatusEntidades se on s.status.idstatus = se.idstatus
     AND se.cancelado = true
     AND se.finalizado = true
ORDER BY s.idsprint
""")
    List<SprintListagemDTO> listarSprints();

    @Query("""
        SELECT new br.com.taskcontroller.DTO.Relatorios.RelatorioHorasTarefaDTO(
               s.idsprint,
               ep.idepico,
               ep.nome,
               e.idestoria,
               e.descestoria,
               t.idtarefa,
               t.desctarefa,
               r.nome,
               st.descstatus,
               COALESCE(t.horas_estimadas, 0),
               COALESCE(t.horas_realizadas, 0),
               "",
               "",
               COALESCE(t.horas_estimadas - t.horas_realizadas, 0),
               "",
               0
          )
    FROM Sprint s
    JOIN SprintEstoria se ON se.sprint.idsprint = s.idsprint
    JOIN se.estoria e
    JOIN e.epico ep
    JOIN Tarefa t ON t.estoria.idestoria = e.idestoria
    LEFT JOIN t.responsavel r
    LEFT JOIN t.status st
    WHERE s.idsprint IN (:idSprint)
    ORDER BY
            s.dtiniciosprint,
            s.idsprint,
            ep.idepico,
            e.idestoria,
            t.idtarefa
""")
    List<RelatorioHorasTarefaDTO> gerarRelatorioHorasDetalhado(@Param("idSprint") List<Long> idSprint);
}
