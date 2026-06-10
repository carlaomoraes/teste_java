package br.com.taskboard.demo.Service;


import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    public Optional<Usuario> autenticar(String login, String senha) {
        Optional<Usuario> usuario = repository.findByLoginAndSenha(login, senha);
        if (usuario.isPresent()) {
            return usuario;
        }
        return Optional.empty();
    }
}