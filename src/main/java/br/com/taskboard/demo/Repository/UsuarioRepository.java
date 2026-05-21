package br.com.taskboard.demo.Repository;

import br.com.taskboard.demo.DTO.Usuario;

import java.util.List;

public interface UsuarioRepository  {
    Usuario findById(Long id);
    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(Usuario usuario);
}
