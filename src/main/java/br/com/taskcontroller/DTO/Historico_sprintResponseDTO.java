package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Estoria;

import java.time.LocalDate;

public class Historico_sprintResponseDTO {
    private Long idhistoricosprint ;
    private Estoria estoria;
    private LocalDate dtiniciosprint;
    private LocalDate dtfinalsprint;
}
