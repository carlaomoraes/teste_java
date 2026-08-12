package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Record.Usuario.UsuarioListagemDTO;
import br.com.taskcontroller.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    @Query("""
    SELECT new br.com.taskcontroller.Record.Usuario.UsuarioListagemDTO(
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
    ORDER BY u.nome
    """)
    List<UsuarioListagemDTO> listar();

    @Query("""
    SELECT new br.com.taskcontroller.Record.Usuario.UsuarioListagemDTO(
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
   WHERE u.idusuario = :idusuario
    ORDER BY u.nome
    """)
    UsuarioListagemDTO buscarPorLinha(@Param("idusuario") Long idusuario);


}
