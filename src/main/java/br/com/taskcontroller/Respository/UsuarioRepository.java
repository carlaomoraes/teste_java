package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

}
