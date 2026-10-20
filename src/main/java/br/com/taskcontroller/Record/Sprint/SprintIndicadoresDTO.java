package br.com.taskcontroller.Record.Sprint;

import java.math.BigDecimal;
import java.time.LocalTime;

public record SprintIndicadoresDTO(
        Long concluidas,
        Long emandamento,
        Long atrasadas,
        BigDecimal capacidade,
        BigDecimal bruta,
        BigDecimal liquida,
        BigDecimal porcentagem,
        BigDecimal ausencias,
        BigDecimal horasEstimadas,
        BigDecimal ocupacao,
        BigDecimal saldoHoras
) {}