package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
