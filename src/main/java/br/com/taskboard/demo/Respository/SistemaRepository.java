package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Sistema;;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SistemaRepository extends JpaRepository<Sistema, Long> {

}
