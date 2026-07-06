package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Estoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EpicoEstoriasRepository extends JpaRepository<Estoria, Long> {
    @Query("""

            SELECT e
            FROM Estoria e
           WHERE e.idestoria = :idestoria
          """)
    Estoria buscarPorId(@Param("idestoria") Long idestoria);

       @Query("""                                                         
         SELECT e
           FROM Estoria e
          WHERE e.idepico = :idepico
       ORDER BY e.descestoria
       """)
     List<Estoria> buscarEstoriaPorEpico(@Param("idepico") Long idepico);


    @Query("""
        SELECT e
          FROM Estoria e
         WHERE e.idepico IS NULL
         ORDER BY e.descestoria
    """)
    List<Estoria> buscarEstoriasDisponiveis();

    @Modifying
    @Transactional
    @Query("""
        DELETE
          FROM Estoria e
         WHERE e.idepico = :idEpico
           AND e.idestoria = :idEstoria
    """)
    void removerDoEpico(
            @Param("idEpico") Long idEpico,
            @Param("idEstoria") Long idEstoria);

    @Query("""
       SELECT COUNT(e)
       FROM Estoria e
       WHERE e.idepico = :idEpico         
    """)
    long contarRelacionamentos(@Param("idEpico") Long idEpico);
}