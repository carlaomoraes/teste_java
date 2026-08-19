package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Record.COMBO.UsuarioComboDTO;
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
        p.descpapel
    )
    FROM Usuario u
    JOIN u.papel p
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
        p.descpapel
    )
    FROM Usuario u
    JOIN u.papel p
   WHERE u.idusuario = :idusuario
    ORDER BY u.nome
    """)
    UsuarioListagemDTO buscarPorLinha(@Param("idusuario") Long idusuario);

    @Query("""
    SELECT new br.com.taskcontroller.Record.COMBO.UsuarioComboDTO(
        u.idusuario,
        u.nome
    )
    FROM Usuario u
    JOIN u.papel p
    ORDER BY u.nome
    """)
    List<UsuarioComboDTO> montaCombo();
}
