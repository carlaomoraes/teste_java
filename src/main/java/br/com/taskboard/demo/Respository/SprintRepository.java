package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<Sprint, Long> {

}
