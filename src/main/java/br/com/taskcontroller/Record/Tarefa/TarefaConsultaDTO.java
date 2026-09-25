package br.com.taskcontroller.Record.Tarefa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TarefaConsultaDTO(
        Long idtarefa,
        String desctarefa,
        Long idestoria,
        Long idstatus,
        String descstatus,
        String corstatus,
        Long idcriador,
        String nomecriador,
        Long idresponsavel,
        String nomeresponsavel,
        BigDecimal horas_estimadas,
        BigDecimal horas_realizadas,
        Long idtipotarefa,
        String desctipotarefa,
        boolean bloqueada,
        LocalDate data_fim_prevista,
        LocalDate data_conclusao,
        LocalDate data_inicio
) {
}