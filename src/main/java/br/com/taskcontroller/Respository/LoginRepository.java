package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Usuario, Long> {
    // O Spring Data gera essa consulta automaticamente baseada no nome do metodo!
    Optional<Usuario> findByLogin(String login);
}