package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Record.Usuario.UsuarioAutenticacaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Usuario, Long> {
    // O Spring Data gera essa consulta automaticamente baseada no nome do metodo!
    @Query("""
SELECT new br.com.taskcontroller.Record.Usuario.UsuarioAutenticacaoDTO(
      u.idusuario,
      u.nome,
      u.login,
      u.senha,
      u.papel.idpapel,
      u.empreendimento.idempreendimento
)
FROM Usuario u
WHERE u.login = :login
""")
    UsuarioAutenticacaoDTO findByLogin(@Param("login") String login);
}