package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.SprintHistorico;
import br.com.taskcontroller.Record.Sprint.SprintHistoricoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SprintHistoricoRepository extends JpaRepository<SprintHistorico, Long> {

    List<SprintHistorico> findBySprint_IdsprintOrderByDataAlteracaoDesc(Long idSprint);

    @Query("""
            SELECT new br.com.taskcontroller.Record.Sprint.SprintHistoricoDTO(
                sh.idhistorico,
                sh.sprint.idsprint,
                sh.usuario.idusuario,
                u.nome,
                sh.dataAlteracao,
                sh.tipo_alteracao,
                sh.valor_anterior,
                sh.valor_novo,
                sh.descricao
            )
            FROM SprintHistorico sh
            JOIN sh.usuario u
           WHERE sh.sprint.idsprint = :idsprint
    """)
    List<SprintHistoricoDTO> listaHistorico(@Param("idsprint") Long idsprint);

}
