package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.TarefaHistorico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaHistoricoRepository extends JpaRepository<TarefaHistorico, Long> {

    List<TarefaHistorico> findByTarefaIdtarefaOrderByDataAlteracaoDescIdhistoricoDesc(Long idTarefa);
}
