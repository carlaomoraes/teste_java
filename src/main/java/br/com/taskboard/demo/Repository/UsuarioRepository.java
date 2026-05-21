package br.com.taskboard.demo.Repository;

import br.com.taskboard.demo.DTO.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findById(Long idUsuario);
    List<Usuario> findAll();
    Usuario save(Usuario usuario);
//    void update(Long id, Usuario usuario);
//    void deleteById(Long id);
}
