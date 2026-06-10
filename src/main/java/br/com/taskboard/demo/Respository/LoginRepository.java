package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Usuario, Long> {
    // O Spring Data gera essa consulta automaticamente baseada no nome do método!
    Optional<Usuario> findByLoginAndSenha(String login, String senha);
}