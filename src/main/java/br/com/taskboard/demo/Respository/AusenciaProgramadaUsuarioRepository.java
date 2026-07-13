package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.AusenciaProgramada;
import br.com.taskboard.demo.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AusenciaProgramadaUsuarioRepository
        extends JpaRepository<AusenciaProgramada, Long> {

    @Query("""
        select a
        from AusenciaProgramada a
        join fetch a.tipoausencia
        where a.idusuario.idusuario = :idusuario
        """)
    List<AusenciaProgramada> buscarPorUsuario(
            @Param("idusuario") Long idusuario);
}