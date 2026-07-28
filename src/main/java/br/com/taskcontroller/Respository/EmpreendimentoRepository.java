package br.com.taskcontroller.Respository;

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
                               ee.data_inicio,
                               ee.data_cadastro,
                               ee.data_fim,
                               ee.status.descstatus,
                               ee.cor,
                               ee.percentual
                           )
                           FROM Empreendimento ee
                           WHERE ee.ativo = 1
                           ORDER BY ee.descempreendimento
""")
    List<EmpreendimentoDTO> findByAtivoTrue();
}
