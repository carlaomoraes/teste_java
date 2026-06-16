package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.TipoAusencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoAusenciaRepository extends JpaRepository<TipoAusencia, Long> {

}
