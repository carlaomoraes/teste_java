package br.com.taskcontroller.Record.Sprint;

public record TarefaQuadroDTO(
        Long idestoria,
        String descestoria,
        Long idespico,
        String nomeepico,
        String cor,
        Long idtarefa,
        String desctarefa,
        int horas_estimadas,
        int horas_realizadas,
        Long idcriador,
        String nomecriador,
        Long idresponsavel,
        String nomeresponsavel,
        Long idstatus,
        String descstatus,
        String corstatus
) {}