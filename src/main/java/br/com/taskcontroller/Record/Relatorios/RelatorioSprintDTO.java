package br.com.taskcontroller.Record.Relatorios;

import java.time.LocalDate;

public record RelatorioSprintDTO(
    Long idempreendimento,
    String descempreendimento,
    String descsprint,
    LocalDate dtiniciosprint,
    LocalDate dtfinalsprint,
    String descstatus,
    Long contEstorias,
    Long contTarefas,
    Long totalHorasEstimadas,
    Long totalHorasRealizadas,
    String totalHorasEstimadas60,
    String totalHorasRealizadas60,
    Long progresso
) {
}
