package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.SprintEstoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SprintEstoriaRepository extends JpaRepository<SprintEstoria, Long> {
 @Query("""
    SELECT se
      FROM SprintEstoria se
     WHERE se.sprint.idsprint = :idSprint
       AND se.estoria.idestoria = :idEstoria
""")
 SprintEstoria buscarSprintEstoria(
         @Param("idSprint") Long idSprint,
         @Param("idEstoria") Long idEstoria
 );
}