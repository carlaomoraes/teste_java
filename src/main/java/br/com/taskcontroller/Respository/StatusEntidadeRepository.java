package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Record.Status.TipoEntidadeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusEntidadeRepository
        extends JpaRepository<StatusEntidades, Long> {

    @Query("""
    SELECT new br.com.taskcontroller.Record.Status.TipoEntidadeDTO(
        t.idtipo_entidade,
        t.desctipo_entidade,
        t.ativo   
    )
    FROM TipoEntidade t
   WHERE t.ativo = true
    ORDER BY t.idtipo_entidade
    """)
    List<TipoEntidadeDTO> montaComboTipoEntidade();

}