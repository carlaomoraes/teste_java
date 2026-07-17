package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Estoria;

import java.time.LocalDate;

public class Historico_sprintRequestDTO {
    private Long idhistoricosprint ;
    private Estoria estoria;
    private LocalDate dtiniciosprint;
    private LocalDate dtfinalsprint;
}
