package br.com.taskcontroller.Record.Sprint;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public record TarefaQuadroDTO(
        Long idsprint,
        String descsprint,
        Long idestoria,
        String descestoria,
        Long idespico,
        String nomeepico,
        String cor,
        Long idtarefa,
        String desctarefa,
        BigDecimal horas_estimadas,
        BigDecimal horas_realizadas,
        Long idcriador,
        String nomecriador,
        Long idresponsavel,
        String nomeresponsavel,
        Long idstatus,
        String descstatus,
        String corstatus
) {}