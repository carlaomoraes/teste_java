package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.EquipeUsuario;
import br.com.taskcontroller.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EquipeUsuarioRepository extends JpaRepository<EquipeUsuario, Long> {
    @Query("""
       select distinct eu
       from EquipeUsuario eu
       where eu.equipe.idequipe = :idequipe
       """)
    List<EquipeUsuario> listarMembros(Long idequipe);
    @Modifying
    @Transactional
    @Query("""
       delete
       from EquipeUsuario eu
       where eu.equipe.idequipe = :idEquipe
       and eu.usuario.idusuario = :idUsuario
       """)
    void removerMembro(
                    @Param("idEquipe") Long idEquipe,
                    @Param("idUsuario") Long idUsuario);

    @Query("""
    SELECT DISTINCT eu.usuario
    FROM EquipeUsuario eu
    WHERE eu.equipe.idequipe = :idequipe
    ORDER BY eu.usuario.nome
""")
    List<Usuario> buscarUsuariosPorEquipe(@Param("idequipe") Long idequipe);

    @Query("""
    SELECT DISTINCT u
      FROM Usuario u
     WHERE u.idusuario NOT IN (SELECT eu.usuario.idusuario
                                 FROM EquipeUsuario eu
                                WHERE eu.equipe.idequipe = :idequipe)
  ORDER BY u.nome""")
    List<Usuario> buscarUsuariosDisponiveis(@Param("idequipe") Long idequipe);
}
