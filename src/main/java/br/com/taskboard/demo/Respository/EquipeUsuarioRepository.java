package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.EquipeUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EquipeUsuarioRepository extends JpaRepository<EquipeUsuario, Long> {
    @Query("""
       select eu
       from EquipeUsuario eu
       where eu.equipe.idequipe = :idequipe
       """)
    List<EquipeUsuario> listarMembros(Long idequipe);
    Optional<EquipeUsuario> findByEquipe_IdEquipeAndUsuario_IdUsuario(
            Long idequipe,
            Long idusuario);
}
