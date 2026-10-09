package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Record.COMBO.EstoriaComboDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

}
