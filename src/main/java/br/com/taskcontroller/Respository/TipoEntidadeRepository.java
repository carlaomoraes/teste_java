package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.TipoEntidade;
import br.com.taskcontroller.Record.Status.StatusEntidadesListagemDTO;
import br.com.taskcontroller.Record.Status.TipoEntidadeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoEntidadeRepository extends JpaRepository<TipoEntidade, Long> {

    @Query("""
    SELECT new br.com.taskcontroller.Record.Status.TipoEntidadeDTO(
        t.idtipo_entidade,
        t.desctipo_entidade,
        t.ativo
    )
    FROM TipoEntidade t
   WHERE t.ativo = true
    ORDER BY t.idtipo_entidade
    """)
    List<TipoEntidadeDTO> montaComboTipoEntidade();

    @Query("""
    SELECT new br.com.taskcontroller.Record.Status.StatusEntidadesListagemDTO(
        s.idstatus,
        s.descstatus,
        s.ordem,
        s.cor,
        s.inicial,
        s.finalizado,
        s.cancelado,
        s.ativo,
        t.idtipo_entidade,
        t.desctipo_entidade
    )
    FROM StatusEntidades s
    JOIN s.tipoentidade t
   WHERE t.idtipo_entidade = :idTipoEntidade
    ORDER BY s.ordem
    """)
    List<StatusEntidadesListagemDTO> listar(@Param("idTipoEntidade") Long idTipoEntidade);

    @Query("""
    SELECT new br.com.taskcontroller.Record.Status.StatusEntidadesListagemDTO(
        s.idstatus,
        s.descstatus,
        s.ordem,
        s.cor,
        s.inicial,
        s.finalizado,
        s.cancelado,
        s.ativo,
        t.idtipo_entidade,
        t.desctipo_entidade
    )
    FROM StatusEntidades s
    JOIN s.tipoentidade t
   WHERE s.idstatus = :idstatus
   """)
    StatusEntidadesListagemDTO buscarPorLinha(@Param("idstatus") Long idstatus);

    @Query("""
    SELECT COALESCE(MAX(s.ordem), 0)
    FROM StatusEntidades s
    WHERE s.tipoentidade.idtipo_entidade = :idTipoEntidade
""")
    Integer buscarMaiorOrdem(@Param("idTipoEntidade") Long idTipoEntidade);
}
