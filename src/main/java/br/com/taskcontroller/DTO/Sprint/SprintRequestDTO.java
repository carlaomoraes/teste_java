package br.com.taskcontroller.DTO.Sprint;

import java.time.LocalDate;

public record SprintRequestDTO(
        Long idsprint,
        String descsprint,
        LocalDate dtiniciosprint,
        LocalDate dtfinalsprint,
        Boolean visivel,
        Long idstatus,
        Long idempreendimento
) {}