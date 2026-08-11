package br.com.taskcontroller.Record.Ausencia;

import java.time.LocalDate;

public record AusenciaInclusaoDTO(
        Long idusuario,
        LocalDate data_inicio,
        LocalDate data_fim,
        String observacao,
        Long idtipoausencia
) {
}
