package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.StatusTransicao;
import br.com.taskcontroller.Record.Status.StatusTransicaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface StatusTransicaoRepository
        extends JpaRepository<StatusTransicao, Long> {

    List<StatusTransicao> findByStatusOrigemIdstatusOrderByStatusDestinoOrdem(Long idStatus,
                                                                              Long idTipo_Entidade,
                                                                              Long idEmpreendimento);
    @Query("""
        SELECT new br.com.taskcontroller.Record.Status.StatusTransicaoDTO(
                    idstatus,
                    descstatus,
                    ativo,
                    ordem)
        FROM StatusEntidades s
       WHERE s.empreendimento.idempreendimento = :idEmpreendimento
        AND s.tipoentidade.idtipo_entidade = :idTipoEntidade
""")
    List<StatusTransicaoDTO> montaTransicao(Long idEmpreendimento,
                                            Long idTipoEntidade);

    @Query("""
    SELECT new br.com.taskcontroller.Record.Status.StatusTransicaoDTO(
                    idstatus,
                    descstatus,
                    ativo,
                    ordem)
          FROM StatusEntidades s
     WHERE s.empreendimento.idempreendimento = :idEmpreendimento
       AND s.tipoentidade.idtipo_entidade = :idTipoEntidade
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
            @Param("idEmpreendimento") Long idEmpreendimento,
            @Param("idTipoEntidade") Long idTipoEntidade,
            @Param("idStatusOrigem") Long idStatusOrigem);
}