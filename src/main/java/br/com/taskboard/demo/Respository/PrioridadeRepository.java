package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrioridadeRepository extends JpaRepository<Prioridade, Long> {

}
