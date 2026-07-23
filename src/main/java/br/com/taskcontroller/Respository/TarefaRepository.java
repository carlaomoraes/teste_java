package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Modelo.Tarefa;;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    boolean existsByEstoriaAndAtivaTrue(Estoria estoria);

    List<Tarefa> findByEstoria_Idestoria(Long idEstoria);
}
