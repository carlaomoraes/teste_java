package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Record.EstoriaListagemDTO;
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
             and e.epico.idepico = :idepico
          """)
    Estoria buscarPorId(@Param("idestoria") Long idestoria,
                        @Param("idepico") Long idepico);

       @Query("""                                                         
         SELECT e
           FROM Estoria e
          WHERE e.epico.idepico = :idepico
       ORDER BY e.descestoria
       """)
     List<Estoria> buscarEstoriaPorEpico(@Param("idepico") Long idepico);


    @Query("""
        SELECT e
          FROM Estoria e
         WHERE e.epico.idepico IS NULL
         ORDER BY e.descestoria
    """)
    List<Estoria> buscarEstoriasDisponiveis();

    @Modifying
    @Transactional
    @Query("""
        DELETE
          FROM Estoria e
         WHERE e.epico.idepico = :idepico
           AND e.idestoria = :idEstoria
    """)
    void removerDoEpico(
            @Param("idEpico") Long idEpico,
            @Param("idEstoria") Long idEstoria);

    @Query("""
       SELECT COUNT(e)
       FROM Estoria e
       WHERE e.epico.idepico = :idepico
    """)
    long contarRelacionamentos(@Param("idEpico") Long idEpico);

    @Query("""
    SELECT new br.com.taskcontroller.Record.EstoriaListagemDTO(
        e.idestoria,
        e.descestoria
    )
    FROM Estoria e
    WHERE e.epico.idepico = :idepico
""")
    List<EstoriaListagemDTO> listaEstoriasPorEpico(@Param("idepico") Long idepico);
}