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
}