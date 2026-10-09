package br.com.taskcontroller.Record.TempoGasto;

import java.time.LocalDate;
import java.time.LocalTime;

public record TempoGastoDTO(
    Long idtempogasto,
    Long idtarefa,
    String desctarefa,
    Long idusuario,
    String nomeusuario,
    LocalDate data_execucao,
    LocalTime hora_execucao
    )
{
}
