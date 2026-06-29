package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.EmpreendimentoEquipe;
import br.com.taskboard.demo.Modelo.Equipe;
import br.com.taskboard.demo.Modelo.EquipeUsuario;
import br.com.taskboard.demo.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EquipeEmpreendimentoRepository extends JpaRepository<EmpreendimentoEquipe, Long> {
    @Query("""
    SELECT ee
      FROM EmpreendimentoEquipe ee
     WHERE ee.empreendimento.idempreendimento = :idempreendimento
""")
    List<EmpreendimentoEquipe> listarMembros(
            @Param("idempreendimento") Long idempreendimento);
    @Modifying
    @Transactional
    @Query("""
    DELETE
      FROM EmpreendimentoEquipe ee
     WHERE ee.equipe.idequipe = :idEquipe
       AND ee.empreendimento.idempreendimento = :idEmpreendimento
""")
    void removerMembro(
            @Param("idEquipe") Long idEquipe,
            @Param("idEmpreendimento") Long idEmpreendimento);

    @Query("""
    SELECT ee.equipe
      FROM EmpreendimentoEquipe ee
     WHERE ee.empreendimento.idempreendimento = :idempreendimento
     ORDER BY ee.equipe.descequipe
""")
    List<Equipe> buscarEquipesPorEmpreendimento(@Param("idempreendimento") Long idempreendimento);

    @Query("""
    SELECT e
      FROM Equipe e
     WHERE e.idequipe NOT IN (
            SELECT ee.equipe.idequipe
              FROM EmpreendimentoEquipe ee
             WHERE ee.empreendimento.idempreendimento = :idempreendimento
     )
     ORDER BY e.descequipe
""")
    List<Equipe> buscarEquipesDisponiveis(
            @Param("idempreendimento") Long idempreendimento);

    boolean existsByEmpreendimentoIdempreendimentoAndEquipeIdequipe(
            Long idempreendimento,
            Long idequipe);
}
