package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.EstoriaHistorico;
import br.com.taskcontroller.Record.Estoria.EstoriaHistoricoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstoriaHistoricoRepository extends JpaRepository<EstoriaHistorico, Long> {

    List<EstoriaHistorico> findByEstoriaIdestoriaOrderByIdhistoricoDesc(
            Long idEstoria
    );
    @Query("""
            SELECT new br.com.taskcontroller.Record.Estoria.EstoriaHistoricoDTO(
                te.idhistorico,
                te.estoria.idestoria,
                te.usuario.idusuario,
                u.nome,
                te.dataAlteracao,
                te.tipo_alteracao,
                te.valor_anterior,
                te.valor_novo,
                te.descricao
            )
            FROM EstoriaHistorico te
            JOIN te.usuario u
            JOIN te.estoria e
           WHERE te.estoria.idestoria = :idestoria
    """)
    List<EstoriaHistoricoDTO> listaHistorico(@Param("idestoria") Long idestoria);

}
