package br.com.taskcontroller.Respository;

import br.com.taskcontroller.DTO.COMBO.EmpreendimentoComboDTO;
import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Record.Empreendimento.EmpreendimentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long> {
    @Query("""
    SELECT new br.com.taskcontroller.Record.Empreendimento.EmpreendimentoDTO(
        ee.idempreendimento,
        ee.descempreendimento,
        ee.codempreendimento,
        ee.data_inicio,
        ee.data_fim,
        ee.data_cadastro,
        ee.siglaempreendimento,
        ee.ativo,
        ee.status.idstatus,
        ee.status.descstatus,
        p.idprioridade,
        p.descprioridade,
        p.corprioridade,
        ee.cor,
        ee.percentual,
        u.idusuario,
        u.nome,
        ee.duracao_sprint,
        ee.permitir_sprint_sobreposta,
        ee.permitir_multiplas_sprint_ativas,
        ee.horas_trabalho_dia,
        ee.considerar_feriados
        )
    FROM Empreendimento ee
    JOIN StatusEntidades se on ee.status.idstatus = se.idstatus
    JOIN Prioridades p on ee.prioridade.idprioridade = p.idprioridade
    JOIN Usuario u on ee.gestor.idusuario = u.idusuario
    WHERE ee.ativo = 1
    ORDER BY ee.prioridade.idprioridade DESC
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
    @Query("""
    SELECT new br.com.taskcontroller.Record.Empreendimento.EmpreendimentoDTO(
        ee.idempreendimento,
        ee.descempreendimento,
        ee.codempreendimento,
        ee.data_inicio,
        ee.data_fim,
        ee.data_cadastro,
        ee.siglaempreendimento,
        ee.ativo,
        ee.status.idstatus,
        ee.status.descstatus,
        p.idprioridade,
        p.descprioridade,
        p.corprioridade,
        ee.cor,
        ee.percentual,
        u.idusuario,
        u.nome,
        ee.duracao_sprint,
        ee.permitir_sprint_sobreposta,
        ee.permitir_multiplas_sprint_ativas,
        ee.horas_trabalho_dia,
        ee.considerar_feriados
    )
    FROM Empreendimento ee
    JOIN StatusEntidades se on ee.status.idstatus = se.idstatus
    JOIN Prioridades p on ee.prioridade.idprioridade = p.idprioridade
    JOIN Usuario u on ee.gestor.idusuario = u.idusuario
    WHERE ee.idempreendimento = :idempreendimento
""")
    EmpreendimentoDTO buscaPorIdDTO(Long idempreendimento);
}
