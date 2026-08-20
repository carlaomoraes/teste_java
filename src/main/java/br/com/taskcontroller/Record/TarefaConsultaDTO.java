package br.com.taskcontroller.Record;

import java.time.LocalDate;

public record TarefaConsultaDTO(
        Long idtarefa,
        Long idestoria,
        Long idstatus,
        String descstatus,
        String desctarefa,
        Long idcriador,
        String nomecriador,
        Long idresponsavel,
        String nomeresponsavel,
        Long horas_estimadas,
        Long horas_realizadas,
        Long idtipotarefa,
        String desctipotarefa,
        boolean bloqueada,
        LocalDate data_fim_prevista,
        LocalDate data_conclusao,
        LocalDate data_inicio
) {
}