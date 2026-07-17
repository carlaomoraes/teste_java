package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Empreendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long> {
    @Query("""
    SELECT ee
      FROM Empreendimento ee
     WHERE ee.ativo = 1
""")
    List<Empreendimento> findByAtivoTrue();
}
