package br.com.taskcontroller.Record.Sprint;

import java.math.BigDecimal;

public record SprintIndicadoresDTO(
        Long concluidas,
        Long emandamento,
        Long atrasadas,
        BigDecimal capacidade
) {}