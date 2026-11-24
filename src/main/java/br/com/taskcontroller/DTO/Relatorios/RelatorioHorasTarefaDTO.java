package br.com.taskcontroller.DTO.Relatorios;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RelatorioHorasTarefaDTO {
    Long idtarefa;
    String desctarefa;
    String responsavel;
    String descStatus;

    BigDecimal horasEstimadas;
    BigDecimal horasRealizadas;
    BigDecimal saldo;
    BigDecimal desvioPorc;
}
