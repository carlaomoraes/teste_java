package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Projection.GridEmpreendimentoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long> {
    @Query("""
       SELECT ee.idempreendimento AS idempreendimento,
              ee.descempreendimento AS descempreendimento,
              ee.data_inicio as data_inicio,
              ee.data_fim as data_fim,
              ee.data_cadastro as data_cadastro,
              p.descprioridade as prioridade,
              s.descstatus as status,
              ee.siglaempreendimento as siglaempreendimento,
              ee.cor,
              u.idusuario as idgestor,
              u.nome as nomegestor
         FROM Empreendimento ee
         JOIN Prioridades p on p.idprioridade = ee.prioridade.idprioridade
         JOIN StatusEntidades s on s.idstatus = ee.status.idstatus
         JOIN Usuario u on u.idusuario = ee.idgestor.idusuario
        WHERE ee.ativo = 1
     ORDER BY ee.prioridade.idprioridade desc
       """)
    List<GridEmpreendimentoProjection> findByAtivoTrue();
}