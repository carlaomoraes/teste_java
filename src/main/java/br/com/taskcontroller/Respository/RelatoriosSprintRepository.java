package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Sprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO;

import java.util.List;

public interface RelatoriosSprintRepository extends JpaRepository<Sprint, Long> {
    @Query("""
    SELECT new br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO(
        s.empreendimento.idempreendimento,
        s.empreendimento.descempreendimento,
        s.descsprint,
        s.dtiniciosprint,
        s.dtfinalsprint,
        s.status.descstatus,
        COUNT(DISTINCT(e.idestoria)),
        COUNT(DISTINCT(t.idtarefa)),
        sum(t.horas_estimadas),
        sum(t.horas_realizadas),
        0,
        0,
        COALESCE(sum(t.horas_estimadas / t.horas_realizadas),0)
    )
    FROM Sprint s
    JOIN SprintEstoria se on se.sprint.idsprint = s.idsprint
    JOIN se.estoria e
    LEFT JOIN Tarefa t on t.estoria.idestoria = e.idestoria

    WHERE s.empreendimento.idempreendimento = :idempreendimento
    
    GROUP BY
        s.empreendimento.idempreendimento,
        s.empreendimento.descempreendimento,
        s.descsprint,
        s.dtiniciosprint,
        s.dtfinalsprint,
        s.status.descstatus
    ORDER BY s.dtiniciosprint
""")
    List<RelatorioSprintDTO> relatorioSprintPorEmpreendimento(@Param("idempreendimento") Long idempreendimento);
}
