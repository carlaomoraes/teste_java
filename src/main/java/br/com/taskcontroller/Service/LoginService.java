package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Respository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private LoginRepository repository;

    public Optional<Usuario> autenticar(String login, String senha) {
        Optional<Usuario> usuario = repository.findByLogin(login);
        return usuario;
//        if (usuario.isPresent() && encoder.matches(usuario.get().getSenha(), senha)) {
//            return usuario;
//        }
//        return Optional.empty();
    }
}