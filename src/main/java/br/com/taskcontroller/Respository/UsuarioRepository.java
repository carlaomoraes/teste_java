package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Record.UsuarioListagemDTO;
import br.com.taskcontroller.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    @Query("""
    SELECT new br.com.taskcontroller.Record.UsuarioListagemDTO(
        u.idusuario,
        u.nome,
        u.login,
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
}
