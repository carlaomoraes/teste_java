package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Epico;
import br.com.taskcontroller.Record.EquipeCardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpicoRepository extends JpaRepository<Epico, Long> {
    @Query("""
    SELECT ee
      FROM Epico ee
     WHERE ee.ativo = 1
""")
    List<Epico> findByAtivoTrue();

    @Query("""
SELECT new br.com.taskcontroller.Record.EquipeCardDTO(
    ee.equipe.idequipe,
    ee.equipe.nomeequipe,
    COUNT(e),
    COUNT(t),
    COALESCE(SUM(t.horas_estimadas),0L),
    COALESCE(SUM(t.horas_realizadas),0L)
)
FROM Tarefa t
JOIN t.estoria e
JOIN e.empreendimento_Equipe ee
WHERE ee.empreendimento.idempreendimento = :idEmpreendimento
GROUP BY ee.equipe.idequipe, ee.equipe.nomeequipe
""")
    List<EquipeCardDTO> buscarResumoEquipes(@Param("idEmpreendimento") Long idEmpreendimento);

}
