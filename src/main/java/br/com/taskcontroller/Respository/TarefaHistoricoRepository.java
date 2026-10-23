package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.TarefaHistorico;
import br.com.taskcontroller.Record.Tarefa.TarefaHistoricoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TarefaHistoricoRepository extends JpaRepository<TarefaHistorico, Long> {

    List<TarefaHistorico>
    findByTarefaIdtarefaOrderByIdhistoricoDesc(
            Long idTarefa
    );
    @Query("""
            SELECT new br.com.taskcontroller.Record.Tarefa.TarefaHistoricoDTO(
                th.idhistorico,
                t.idtarefa,
                th.usuario.idusuario,
                u.nome,
                th.dataAlteracao,
                th.tipo_alteracao,
                th.valor_anterior,
                th.valor_novo,
                th.descricao
            )
            FROM TarefaHistorico th
            JOIN th.usuario u
            JOIN th.tarefa t
           WHERE t.idtarefa = :idtarefa
    """)
    List<TarefaHistoricoDTO> listaHistorico(@Param("idtarefa") Long idtarefa);

}
