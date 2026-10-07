package br.com.taskcontroller.Record.TempoGasto;

import java.time.LocalDate;

public record TempoGastoDTO(
    Long idtempogasto,
    Long idtarefa,
    String desctarefa,
    Long idusuario,
    String nomeusuario,
    LocalDate data_execucao,
    LocalDate hora_execucao
    )
{
}
