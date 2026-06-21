package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.EquipeUsuario;
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
 }
