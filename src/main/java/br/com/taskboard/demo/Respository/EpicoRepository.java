package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Epico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpicoRepository extends JpaRepository<Epico, Long> {

}
