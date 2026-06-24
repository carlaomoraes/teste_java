package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.AusenciaProgramada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AusenciaProgramadaRepository  extends JpaRepository<AusenciaProgramada, Long> {
    List<AusenciaProgramada> findByIdusuario_Idusuario(Long idUsuario);
}
