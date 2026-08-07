package br.com.taskcontroller.Respository;

import br.com.taskcontroller.DTO.COMBO.EmpreendimentoComboDTO;
import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Record.EmpreendimentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long> {
    @Query("""
      SELECT new br.com.taskcontroller.Record.EmpreendimentoDTO(
        ee.idempreendimento,
        ee.descempreendimento,
        ee.siglaempreendimento,
        ee.codempreendimento,
        ee.data_cadastro,
        ee.data_inicio,
        ee.data_fim,
        u.idusuario,
        u.nome,
        ee.cor,
        ee.percentual
        )
        FROM Empreendimento ee
         JOIN Prioridades p on p.idprioridade = ee.prioridade.idprioridade
         JOIN StatusEntidades s on s.idstatus = ee.status.idstatus
         JOIN Usuario u on u.idusuario = ee.idgestor.idusuario
        WHERE ee.ativo = 1
     ORDER BY ee.prioridade.idprioridade desc
     """)
    List<EmpreendimentoDTO> findByAtivoTrue();

    @Query("""
    SELECT new br.com.taskcontroller.DTO.COMBO.EmpreendimentoComboDTO(
        e.idempreendimento,
        e.descempreendimento
    )
    FROM Empreendimento e
    WHERE e.ativo = 1
    ORDER BY e.prioridade.idprioridade
""")
    List<EmpreendimentoComboDTO> montaComboEmpreendimento();
}
