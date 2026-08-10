package br.com.taskcontroller.Record;

import java.time.LocalDate;

public record SprintDataDTO(
        Long idempreendimento,
        LocalDate data_inicio,
        LocalDate data_fim,
        int duracao
) {
}
