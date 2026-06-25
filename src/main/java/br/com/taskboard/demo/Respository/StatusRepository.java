package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
