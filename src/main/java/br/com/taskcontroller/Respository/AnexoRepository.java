package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnexoRepository extends JpaRepository<Anexo, Long> {
    List<Anexo> findByEpico_Idepico(Long idepico);
}
