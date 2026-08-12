package br.com.taskcontroller.Service;

import br.com.taskcontroller.Record.Usuario.UsuarioAutenticacaoDTO;
import br.com.taskcontroller.Record.Usuario.UsuarioLoginDTO;
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

    public Optional<UsuarioLoginDTO> autenticar(String login, String senha) {
        UsuarioAutenticacaoDTO usuario = repository.findByLogin(login);
/*
        07/08/2026 - Se der problema na senha
        System.out.println(usuario);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode("admin");
        System.out.println(hash);
*/
        if (usuario != null && encoder.matches(senha, usuario.senha())) {
            UsuarioLoginDTO dto = new UsuarioLoginDTO(
                    usuario.idusuario(),
                    usuario.nome(),
                    usuario.login(),
                    usuario.idPapel(),
                    usuario.idEmpreendimento()
            );
            return Optional.of(dto);
        }

        return Optional.empty();
    }
}