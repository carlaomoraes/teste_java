package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.StatusTransicao;
import br.com.taskcontroller.Record.Status.StatusTransicaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface StatusTransicaoRepository
        extends JpaRepository<StatusTransicao, Long> {

    @Query("""
        SELECT new br.com.taskcontroller.Record.Status.StatusTransicaoDTO(
                    idstatus,
                    descstatus,
                    ativo,
                    ordem)
        FROM StatusEntidades s
       WHERE s.tipoentidade.idtipo_entidade = :idTipoEntidade
""")
    List<StatusTransicaoDTO> buscarProximoStatus(Long idStatus, Long idTipoEntidade);


    @Query("""
        SELECT new br.com.taskcontroller.Record.Status.StatusTransicaoDTO(
                    idstatus,
                    descstatus,
                    ativo,
                    ordem)
        FROM StatusEntidades s
       WHERE s.tipoentidade.idtipo_entidade = :idTipoEntidade
""")
    List<StatusTransicaoDTO> montaTransicao(Long idTipoEntidade);

    @Query("""
    SELECT new br.com.taskcontroller.Record.Status.StatusTransicaoDTO(
                    idstatus,
                    descstatus,
                    ativo,
                    ordem)
          FROM StatusEntidades s
     WHERE s.tipoentidade.idtipo_entidade = :idTipoEntidade
       AND s.idstatus <> :idStatusOrigem
       AND NOT EXISTS (
            SELECT 1
              FROM StatusTransicao st
             WHERE st.statusOrigem.idstatus = :idStatusOrigem
               AND st.statusDestino.idstatus = s.idstatus
       )
     ORDER BY s.ordem
""")
    List<StatusTransicaoDTO> buscarStatusDisponiveis(
            @Param("idTipoEntidade") Long idTipoEntidade,
            @Param("idStatusOrigem") Long idStatusOrigem);
}