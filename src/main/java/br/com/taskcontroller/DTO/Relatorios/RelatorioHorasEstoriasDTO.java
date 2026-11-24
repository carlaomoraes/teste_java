package br.com.taskcontroller.DTO.Relatorios;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RelatorioHorasEstoriasDTO {
    Long idtarefa;
    Long idestoria;
    String descestoria;

    Long idepico;
    String descepico;

    BigDecimal horasEstimadas;
    BigDecimal horasRealizadas;
    BigDecimal saldo;
    BigDecimal desvioPorc;

    List<RelatorioHorasTarefaDTO> tarefas;
}
