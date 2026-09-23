package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.StatusTransicao;
import br.com.taskcontroller.Record.Status.StatusTransicaoDTO;
import br.com.taskcontroller.Record.Status.StatusTransicaoListagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface StatusTransicaoRepository
        extends JpaRepository<StatusTransicao, Long> {

    @Query("""
    SELECT new br.com.taskcontroller.Record.Status.StatusTransicaoDTO(
        destino.idstatus,
        destino.descstatus,
        destino.ativo,
        destino.ordem,
        destino.cor
    )
    FROM StatusTransicao st
    JOIN st.statusOrigem origem
    JOIN st.statusDestino destino
    WHERE origem.idstatus = :idStatus
      AND origem.tipoentidade.idtipo_entidade = :idTipoEntidade
      AND destino.ativo = true
    ORDER BY destino.ordem
""")
    List<StatusTransicaoDTO> buscarProximoStatus(Long idStatus, Long idTipoEntidade);


    @Query("""
        SELECT new br.com.taskcontroller.Record.Status.StatusTransicaoDTO(
                    idstatus,
                    descstatus,
                    ativo,
                    ordem,
                    cor)
        FROM StatusEntidades s
       WHERE s.tipoentidade.idtipo_entidade = :idTipoEntidade
""")
    List<StatusTransicaoDTO> montaTransicao(Long idTipoEntidade);

    @Query("""
    SELECT new br.com.taskcontroller.Record.Status.StatusTransicaoDTO(
                    idstatus,
                    descstatus,
                    ativo,
                    ordem,
                    cor)
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

    @Query("""
    SELECT new br.com.taskcontroller.Record.Status.StatusTransicaoListagemDTO(
        st.idtransicao,
        o.idstatus,
        o.descstatus,
        o.cor,
        d.idstatus,
        d.descstatus,
        d.cor
    )
    FROM StatusTransicao st
    JOIN st.statusOrigem o
    JOIN st.statusDestino d
   WHERE o.tipoentidade.idtipo_entidade = :idTipoEntidade
    ORDER BY o.ordem, d.ordem
""")
    List<StatusTransicaoListagemDTO> listarWorkflow(Long idTipoEntidade);

    boolean existsByStatusOrigemIdstatusAndStatusDestinoIdstatus(Long idStatusOrigem, Long idStatusDestino);
}