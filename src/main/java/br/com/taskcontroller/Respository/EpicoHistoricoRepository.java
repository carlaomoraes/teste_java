package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.EpicoHistorico;
import br.com.taskcontroller.Modelo.EstoriaHistorico;
import br.com.taskcontroller.Record.Epico.EpicoHistoricoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpicoHistoricoRepository extends JpaRepository<EpicoHistorico, Long> {

    List<EpicoHistorico> findByEpicoIdepicoOrderByIdhistoricoDesc(
            Long idepico
    );
    @Query("""
            SELECT new br.com.taskcontroller.Record.Epico.EpicoHistoricoDTO(
                te.idhistorico,
                te.epico.idepico,
                te.usuario.idusuario,
                u.nome,
                te.dataAlteracao,
                te.tipo_alteracao,
                te.valor_anterior,
                te.valor_novo,
                te.descricao
            )
            FROM EpicoHistorico te
            JOIN te.usuario u
            JOIN te.epico e
           WHERE te.epico.idepico = :idepico
    """)
    List<EpicoHistoricoDTO> listaHistorico(@Param("idepico") Long idepico);

}
