package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.TipoTarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoTarefaRepository extends JpaRepository<TipoTarefa, Long> {

}
