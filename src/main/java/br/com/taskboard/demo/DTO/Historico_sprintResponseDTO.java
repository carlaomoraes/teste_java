package br.com.taskboard.demo.DTO;

import br.com.taskboard.demo.Modelo.Estoria;

import java.time.LocalDate;

public class Historico_sprintResponseDTO {
    private Long idhistoricosprint ;
    private Estoria estoria;
    private LocalDate dtiniciosprint;
    private LocalDate dtfinalsprint;
}
