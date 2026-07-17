package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.TipoTarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoTarefaRepository extends JpaRepository<TipoTarefa, Long> {

}
