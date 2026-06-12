package br.com.taskboard.demo.Service;


import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.LoginRepository;
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
//        if (usuario.isPresent() && encoder.matches(senha, usuario.get().getSenha())) {
//            return usuario;
//        }
//        return Optional.empty();
    }
}