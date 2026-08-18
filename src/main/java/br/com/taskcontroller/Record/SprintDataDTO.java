package br.com.taskcontroller.Record;

import java.time.LocalDate;

public record SprintDataDTO(
        Long idsprint,
        Long idempreendimento,
        String descsprint,
        LocalDate dtiniciosprint,
        LocalDate dtfinalsprint,
        boolean Visivel,
        boolean Ativa,
        int duracao
) {
}