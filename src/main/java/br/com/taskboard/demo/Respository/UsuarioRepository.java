package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

    Usuario findByLoginAndSenha(
            String login,
            String senha);
}
