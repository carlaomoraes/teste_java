package br.com.taskcontroller.Respository;

import br.com.taskcontroller.DTO.COMBO.AusenciaComboDTO;
import br.com.taskcontroller.Modelo.AusenciaProgramada;
import br.com.taskcontroller.Record.Ausencia.AusenciaListagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AusenciaProgramadaRepository  extends JpaRepository<AusenciaProgramada, Long> {
    @Query("""
    SELECT new br.com.taskcontroller.Record.Ausencia.AusenciaListagemDTO(
        a.idausencia,
        a.usuario.idusuario,
        a.data_cadastro,
        a.data_inicio,
        a.data_fim,
        a.observacao,
        ta.desc_tipo_ausencia
    )
    FROM AusenciaProgramada a
    JOIN a.tipoausencia ta
    WHERE a.usuario.idusuario = :idUsuario
    ORDER BY a.data_inicio
""")
    List<AusenciaListagemDTO> findByIdusuario_Idusuario(Long idUsuario);

    @Query("""
    SELECT new br.com.taskcontroller.Record.Ausencia.AusenciaListagemDTO(
        a.idausencia,
        a.usuario.idusuario,
        a.data_cadastro,
        a.data_inicio,
        a.data_fim,
        a.observacao,
        a.tipoausencia.desc_tipo_ausencia
    )
    FROM AusenciaProgramada a
    WHERE a.data_inicio <= :data_fim
      AND a.data_fim >= :data_inicio
    ORDER BY a.data_inicio
""")
    List<AusenciaListagemDTO> buscarAusenciasDaSprint(
            @Param("data_inicio") LocalDate data_inicio,
            @Param("data_fim") LocalDate data_fim
    );

    @Query("""
    SELECT new br.com.taskcontroller.DTO.COMBO.AusenciaComboDTO(
        a.id_tipo_ausencia,
        a.desc_tipo_ausencia
    )
    FROM Tipo_Ausencia a
    ORDER BY a.id_tipo_ausencia
""")
    List<AusenciaComboDTO> montaComboAusencia();

 }
