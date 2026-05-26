package br.com.taskboard.demo.Service;


import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario usuario) {

        return repository.save(usuario);
    }

    public List<Usuario> listar() {

        return repository.findAll();
    }

    public Usuario atualizar(Usuario usuario) {

        return repository.save(usuario);
    }

    public void excluir(Long idusuario) {

        repository.delete(repository.findById(Math.toIntExact(idusuario)).orElse(null));
    }

    public Usuario buscarPorId(Integer idusuario) {
        return repository.findById(idusuario).orElse(null);
    }
}