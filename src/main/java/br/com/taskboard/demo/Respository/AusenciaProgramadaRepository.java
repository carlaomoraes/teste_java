package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.AusenciaProgramada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface AusenciaProgramadaRepository  extends JpaRepository<AusenciaProgramada, Long> {
    List<AusenciaProgramada> findByIdusuario_Idusuario(Long idUsuario);


    @Query("""
    select a
    from AusenciaProgramada a
    join fetch a.idusuario
    join fetch a.tipoausencia
    where a.data_inicio <= :data_fim
      and a.data_fim >= :data_inicio
    order by a.idusuario.nome, a.data_inicio
""")
    List<AusenciaProgramada> buscarAusenciasDaSprint(
            @Param("data_inicio") LocalDate data_inicio,
            @Param("data_fim") LocalDate data_fim);
}
