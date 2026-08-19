package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Record.Estoria.EstoriaBacklogDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaConsultaDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaListagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EpicoEstoriasRepository extends JpaRepository<Estoria, Long> {
    @Query("""
            SELECT new br.com.taskcontroller.Record.Estoria.EstoriaConsultaDTO(
        e.idestoria,
        e.descestoria,
        e.status.idstatus,
        s.descstatus,
        r.idusuario,
        r.nome,
        c.idusuario,
        c.nome,
        e.resumo,
        COALESCE(e.pontos,0),
        COALESCE(e.horas_estimadas,0),
        COALESCE(e.horas_realizadas,0),
        e.data_inicio,
        e.data_fim,
        e.bloqueada)
    FROM Estoria e
            JOIN e.status s
            join e.responsavel r
            join e.criador c
           WHERE e.idestoria = :idestoria
             and e.epico.idepico = :idepico
          """)
    EstoriaConsultaDTO buscarPorId(@Param("idestoria") Long idestoria,
                                   @Param("idepico") Long idepico);

    @Query("""
        SELECT e
          FROM Estoria e
         WHERE e.epico.idepico IS NULL
         ORDER BY e.descestoria
    """)
    List<Estoria> buscarEstoriasDisponiveis();

    @Modifying
    @Transactional
    @Query("""
        DELETE
          FROM Estoria e
         WHERE e.epico.idepico = :idepico
           AND e.idestoria = :idEstoria
    """)
    void removerDoEpico(
            @Param("idEpico") Long idEpico,
            @Param("idEstoria") Long idEstoria);

    @Query("""
       SELECT COUNT(e)
       FROM Estoria e
       WHERE e.epico.idepico = :idepico
    """)
    long contarRelacionamentos(@Param("idEpico") Long idEpico);

    @Query("""
    SELECT new br.com.taskcontroller.Record.Estoria.EstoriaListagemDTO(
        e.idestoria,
        e.descestoria,
        e.status.idstatus,
        s.descstatus,
        r.idusuario,
        r.nome,
        c.idusuario,
        c.nome,
        e.resumo,
        COALESCE(e.pontos,0),
        COALESCE(e.horas_estimadas,0),
        COALESCE(e.horas_realizadas,0),
        e.data_inicio,
        e.data_fim,
        e.bloqueada)
    FROM Estoria e
    JOIN e.status s
    join e.responsavel r
    join e.criador c
    WHERE e.epico.idepico = :idepico
""")
    List<EstoriaListagemDTO> listaEstoriasPorEpico(@Param("idepico") Long idepico);

    @Query("""
    SELECT new br.com.taskcontroller.Record.Estoria.EstoriaBacklogDTO(
        e.idestoria,
        e.descestoria,
        s.idstatus,
        s.descstatus,
        c.idusuario,
        c.nome,
        r.idusuario,
        r.nome,
        COALESCE(e.resumo,"N/A"),
        COALESCE(e.pontos,0),
        ep.idepico,
        ep.nome,
        ep.cor,
        p.idprioridade,
        p.descprioridade,
        p.corprioridade)
     FROM Estoria e
    JOIN e.status s
    join e.responsavel r
    join e.criador c
    join e.epico ep
    join ep.prioridade p
    WHERE e.ativa = true
      AND NOT EXISTS (
              SELECT 1
                FROM SprintEstoria se
               WHERE se.estoria.idestoria = e.idestoria
      )
      AND ep.empreendimento.idempreendimento = :idempreendimento
""")
    List<EstoriaBacklogDTO> listaEstoriasBacklog(@Param("idempreendimento") Long idempreendimento);

}