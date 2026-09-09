package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.StatusTransicao;
import br.com.taskcontroller.Record.Status.TipoEntidadeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface StatusTransicaoRepository
        extends JpaRepository<StatusTransicao, Long> {

    List<StatusTransicao> findByStatusOrigemIdstatusOrderByStatusDestinoOrdem(Long idStatus,
                                                                              Long idTipo_Entidade,
                                                                              Long idEmpreendimento);

    @Query("""
    SELECT new br.com.taskcontroller.Record.Status.TipoEntidadeDTO(
                 idstatus, 
                 descstatus,
                 ativo   
    )
    FROM StatusEntidades s
   WHERE s.ativo = true
     AND s.empreendimento.idempreendimento = :idEmpreendimento
      AND s.tipoentidade.idtipo_entidade = :idTipoEntidade
    ORDER BY s.ordem
    """)
    List<TipoEntidadeDTO> montaComboOrigem(Long idTipo_Entidade,
                                           Long idEmpreendimento);

}