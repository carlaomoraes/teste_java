package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Papel;
import br.com.taskcontroller.Record.COMBO.PapelComboDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PapelRepository extends JpaRepository<Papel, Long> {
    @Query("""
    SELECT new br.com.taskcontroller.Record.COMBO.PapelComboDTO(
        p.idpapel,
        p.descpapel,
        p.valorhora
    )
    FROM Papel p
    ORDER BY p.idpapel
    """)
    List<PapelComboDTO> montaComboPapel();
}
