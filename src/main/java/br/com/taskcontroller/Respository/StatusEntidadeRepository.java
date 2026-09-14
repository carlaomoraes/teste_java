package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Record.Status.TipoEntidadeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatusEntidadeRepository
        extends JpaRepository<StatusEntidades, Long> {

    @Query("""
    SELECT COALESCE(MAX(s.ordem), 0)
    FROM StatusEntidades s
    WHERE s.tipoentidade.idtipo_entidade = :idTipoEntidade
""")
    Integer buscarMaiorOrdem(@Param("idTipoEntidade") Long idTipoEntidade);

    @Query("""
        SELECT new br.com.taskcontroller.Record.Status.TipoEntidadeDTO(
                    idstatus,
                descstatus,
                ativo)
        FROM StatusEntidades s
       WHERE s.tipoentidade.idtipo_entidade = :idTipoEntidade
        
""")
    List<TipoEntidadeDTO> montaComboOrigem(@Param("idTipoEntidade") Long idTipoEntidade);

    @Query("""
        SELECT 
                    idstatus,
                    descstatus,
                    ativo
        FROM StatusEntidades s
       WHERE s.tipoentidade.idtipo_entidade = :idTipoEntidade
""")
    List<StatusEntidades> mostraStatusDisponiveis(@Param("idTipoEntidade") Long idTipoEntidade,
                                                  @Param("idStatusOrigem") Long idStatusOrigem);
}