package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
        repository.deleteById(idusuario);
    }

    public Usuario buscarPorId(Long idusuario) {
        return repository.findById(idusuario).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}