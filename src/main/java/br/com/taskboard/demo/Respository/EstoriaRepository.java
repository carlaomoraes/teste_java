package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Estoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoriaRepository extends JpaRepository<Estoria, Long> {

}
