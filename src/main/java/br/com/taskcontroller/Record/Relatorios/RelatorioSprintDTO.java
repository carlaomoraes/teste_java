package br.com.taskcontroller.Record.Relatorios;

import java.time.LocalDate;

public record RelatorioSprintDTO(
    Long idempreendimento,
    String descempreendimento,
    Long idsprint,
    String descsprint,
    LocalDate dtiniciosprint,
    LocalDate dtfinalsprint,
    String descstatus,
    String corstatus,
    Long contEstorias,
    Long contTarefas,
    Long totalHorasEstimadas,
    Long totalHorasRealizadas,
    String totalHorasEstimadas60,
    String totalHorasRealizadas60,
    Long progresso
    ) {
}
