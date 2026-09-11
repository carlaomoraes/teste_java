package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.StatusTransicao;
import br.com.taskcontroller.Record.Status.StatusTransicaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
                ativo)
        FROM StatusEntidades s
       WHERE s.empreendimento.idempreendimento = :idEmpreendimento
        AND s.tipoentidade.idtipo_entidade = :idTipoEntidade
""")
    List<StatusTransicaoDTO> montaTransicao(Long idEmpreendimento,
                                            Long idTipoEntidade);
}