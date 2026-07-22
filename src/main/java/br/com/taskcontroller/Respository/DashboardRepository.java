package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Projection.IndicadorEquipeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DashboardRepository extends JpaRepository<Estoria, Long> {

    @Query(value = """

            SELECT
                             eq.idequipe AS idEquipe,
                             eq.nomeequipe AS nomeEquipe,
                             COUNT(e.idestoria) AS totalEstorias,
                             COALESCE(SUM(tt.total_tarefas), 0) AS totalTarefas,
                             COALESCE(SUM(e.horas_estimadas), 0) AS horasEstimadas,
                             COALESCE(SUM(e.horas_realizadas), 0) AS horasRealizadas,
                             CASE WHEN MAX(em.considerar_valorhoras) = 1 THEN ROUND(COALESCE(SUM(e.horas_estimadas * p.valorhora), 0), 2) ELSE 0 END AS custoEstimado,
                             CASE WHEN MAX(em.considerar_valorhoras) = 1 THEN ROUND(COALESCE(SUM(e.horas_realizadas * p.valorhora), 0), 2) ELSE 0 END AS custoRealizado
                         FROM estoria e\s
                         INNER JOIN empreendimento_equipe ee ON ee.idempreendimento_equipe = e.idempreendimento_equipe
                         INNER JOIN empreendimento em ON em.idempreendimento = ee.idempreendimento
                         INNER JOIN equipe eq ON eq.idequipe = ee.idequipe
                         LEFT JOIN ( SELECT idestoria, COUNT(*) AS total_tarefas\s
                         			  FROM tarefa
                         		  GROUP BY idestoria) tt
                             ON tt.idestoria = e.idestoria
                         
                         LEFT JOIN usuario u
                             ON u.idusuario = e.idresponsavel
                         
                         LEFT JOIN papel p
                             ON p.idpapel = u.idpapel
                         
                         WHERE ee.idempreendimento = :idEmpreendimento
                         
                         GROUP BY
                             eq.idequipe,
                             eq.nomeequipe
        """, nativeQuery = true)
    List<IndicadorEquipeProjection> buscarIndicadoresEquipe(Long idEmpreendimento);

}