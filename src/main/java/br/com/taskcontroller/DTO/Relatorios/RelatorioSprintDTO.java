package br.com.taskcontroller.DTO.Relatorios;

import br.com.taskcontroller.Modelo.Sprint;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RelatorioSprintDTO {
    Long idsprint;
    String descsprint;
    LocalDate dataInicial;
    LocalDate dataFinal;
    Sprint descStatus;
    BigDecimal capacidadeBruta;
    BigDecimal capacidadeLiquida;
    BigDecimal horasEstimadas;
    BigDecimal horasRealizadas;
    BigDecimal saldoEstimadas;
    BigDecimal saldoRealizadas;
    BigDecimal totalAusencias;
    BigDecimal ocupancaoPlanejada;
    BigDecimal ocupancaoLiquida;
    BigDecimal ocupancaoPlanejadaPorc;
    BigDecimal ocupancaoLiquidaPorc;
    BigDecimal totalEpicos;
    BigDecimal totalEstorias;
    BigDecimal totalTarefas;
}
