package br.com.taskcontroller.DTO.Relatorios;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RelatorioTotalHorasDTO {
    private BigDecimal totalHorasEstimadas;
    private BigDecimal totalHorasRealizadas;
    private BigDecimal saldo;

    private String totalHorasEstimadas60;
    private String totalHorasRealizadas60;
    private String saldo60;

    public RelatorioTotalHorasDTO(BigDecimal totalHorasEstimadas, BigDecimal totalHorasRealizadas, BigDecimal saldo, String totalHorasEstimadas60, String totalHorasRealizadas60, String saldo60) {
        this.totalHorasEstimadas = totalHorasEstimadas;
        this.totalHorasRealizadas = totalHorasRealizadas;
        this.saldo = saldo;
        this.totalHorasEstimadas60 = totalHorasEstimadas60;
        this.totalHorasRealizadas60 = totalHorasRealizadas60;
        this.saldo60 = saldo60;
    }

    public RelatorioTotalHorasDTO() {

    }
}
