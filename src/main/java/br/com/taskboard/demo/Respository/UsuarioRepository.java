package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    @Query("""
        SELECT DISTINCT u
        FROM Usuario u
        ORDER BY u.nome
    """)
    List<Usuario> listarUsuarios();
}
