package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Excecoes.ViolacaoChaveEstrangeiraException;
import br.com.taskboard.demo.Excecoes.ViolacaoChavaPrimariaException;
import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.UsuarioRepository;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario usuario) {
        String Messagem = String.format("ID %s deve ser único.", usuario.getIdusuario());
        String senha = encoder.encode(usuario.getSenha());
        usuario.setSenha(senha);
        try {
            repository.save(usuario);
        } catch (StaleObjectStateException e) {
            throw new ViolacaoChavaPrimariaException(Messagem);
        }
        return usuario;
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
        Usuario usuario = buscarPorId(idusuario);
        String Messagem = String.format("Não é possível excluir %s pois ele está vinculado %s.",usuario.getNome(),"Estória");
        try {
            repository.deleteById(idusuario);
        } catch (DataIntegrityViolationException e) {
            throw new ViolacaoChaveEstrangeiraException(Messagem);
        }
    }

    public Usuario buscarPorId(Long idusuario) {
        return repository.findById(idusuario).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}