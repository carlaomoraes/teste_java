package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.AusenciaProgramada;
import br.com.taskcontroller.Record.AusenciaListagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AusenciaProgramadaRepository  extends JpaRepository<AusenciaProgramada, Long> {
    @Query("""
SELECT new br.com.taskcontroller.Record.AusenciaListagemDTO(
    a.idausencia,
    u.idusuario,
    a.data_cadastro,
    a.data_inicio,
    a.data_fim,
    a.observacao,
    u.empreendimento.idempreendimento,
    a.tipoausencia.desc_tipo_ausencia
)
FROM AusenciaProgramada a
JOIN a.idusuario u
JOIN a.tipoausencia ta
WHERE u.idusuario = :idUsuario
ORDER BY u.nome, a.data_inicio
""")
    List<AusenciaListagemDTO> findByIdusuario_Idusuario(Long idUsuario);


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
