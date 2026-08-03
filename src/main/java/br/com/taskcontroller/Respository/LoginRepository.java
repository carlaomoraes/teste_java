package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Record.UsuarioListagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Usuario, Long> {
    // O Spring Data gera essa consulta automaticamente baseada no nome do metodo!
    @Query("""
    SELECT new br.com.taskcontroller.Record.UsuarioListagemDTO(
        u.idusuario,
        u.nome,
        u.login,
        u.senha,
        u.email,
        u.ativo,
        u.alterasenha,
        p.idpapel,
        p.descpapel,
        e.idempreendimento,
        e.descempreendimento
    )
    FROM Usuario u
    JOIN u.papel p
    JOIN u.empreendimento e
   WHERE u.login = :login
    """)

    UsuarioListagemDTO findByLogin(String login);
}