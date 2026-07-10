package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Epico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpicoRepository extends JpaRepository<Epico, Long> {
    @Query("""
    SELECT ee
      FROM Epico ee
     WHERE ee.ativo = 1
""")
    List<Epico> findByAtivoTrue();
}
