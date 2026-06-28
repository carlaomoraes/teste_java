package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario usuario) {
        Usuario usuarioSalvo;
        String senha = encoder.encode(usuario.getSenha());
        usuario.setSenha(senha);
        usuarioSalvo = repository.save(usuario);
        return usuarioSalvo;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario atualizar(Usuario usuario) {
        String senha = encoder.encode(usuario.getSenha());
        usuario.setSenha(senha);
        return repository.save(usuario);
    }


    public void excluir(Long idusuario) {
        repository.deleteById(idusuario);
    }

    public Usuario buscarPorId(Long idusuario) {
        return repository.findById(idusuario).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}