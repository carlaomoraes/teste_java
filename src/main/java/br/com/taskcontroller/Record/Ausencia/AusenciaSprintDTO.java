package br.com.taskcontroller.Record.Ausencia;

import java.time.LocalDate;

public record AusenciaSprintDTO(
        Long idausencia,
        LocalDate data_inicio,
        LocalDate data_fim
)
{
}
