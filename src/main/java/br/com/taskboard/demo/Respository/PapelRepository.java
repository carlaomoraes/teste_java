package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Papel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PapelRepository extends JpaRepository<Papel, Long> {

}
