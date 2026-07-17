package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Empreendimento_Equipe;
import br.com.taskcontroller.Modelo.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EquipeEmpreendimentoRepository extends JpaRepository<Empreendimento_Equipe, Long> {
    @Query("""
    SELECT ee
      FROM Empreendimento_Equipe ee
     WHERE ee.empreendimento.idempreendimento = :idempreendimento
""")
    List<Empreendimento_Equipe> listarMembros(
            @Param("idempreendimento") Long idempreendimento);
    @Modifying
    @Transactional
    @Query("""
    DELETE
      FROM Empreendimento_Equipe ee
     WHERE ee.equipe.idequipe = :idEquipe
       AND ee.empreendimento.idempreendimento = :idEmpreendimento
""")
    void removerMembro(
            @Param("idEquipe") Long idEquipe,
            @Param("idEmpreendimento") Long idEmpreendimento);

    @Query("""
    SELECT ee.equipe
      FROM Empreendimento_Equipe ee
     WHERE ee.empreendimento.idempreendimento = :idempreendimento
     ORDER BY ee.equipe.descequipe
""")
    List<Equipe> buscarEquipesPorEmpreendimento(@Param("idempreendimento") Long idempreendimento);

    @Query("""
    SELECT e
      FROM Equipe e
     WHERE e.idequipe NOT IN (
            SELECT ee.equipe.idequipe
              FROM Empreendimento_Equipe ee
             WHERE ee.empreendimento.idempreendimento = :idempreendimento
     )
     ORDER BY e.descequipe
""")
    List<Equipe> buscarEquipesDisponiveis(@Param("idempreendimento") Long idempreendimento);

    @Query("""
    SELECT COUNT(ee)
      FROM Empreendimento_Equipe ee
     WHERE ee.empreendimento.idempreendimento = :idEmpreendimento
       AND ee.equipe.idequipe = :idEquipe
""")
    long contarRelacionamentos(
            @Param("idEmpreendimento") Long idEmpreendimento,@Param("idEquipe") Long idEquipe);
}
