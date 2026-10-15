package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Record.COMBO.EstoriaComboDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EstoriaRepository extends JpaRepository<Estoria, Long> {
    @Query("""
    SELECT new br.com.taskcontroller.Record.COMBO.EstoriaComboDTO(
        e.idestoria,
        e.descestoria
    )
    FROM Estoria e
    WHERE e.ativa = true
""")
    List<EstoriaComboDTO> listar();

    @Query("""
    SELECT COUNT(e)
    FROM Estoria e
    WHERE e.epico.idepico = :idEpico
      AND e.ativa = true
""")
    Long contarEstorias(@Param("idEpico") Long idEpico);

    @Query("""
    SELECT COUNT(e)
    FROM Estoria e
    WHERE e.epico.idepico = :idEpico
      AND e.ativa = true
      AND e.status.finalizado = true
""")
    Long contarEstoriasConcluidas(@Param("idEpico") Long idEpico);

}
