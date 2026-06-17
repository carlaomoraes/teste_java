package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.AusenciaProgramada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AusenciaProgramadaRepository  extends JpaRepository<AusenciaProgramada, Long> {

}
