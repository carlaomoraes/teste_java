package br.com.taskcontroller.Record.Sprint;

import java.math.BigDecimal;

public record TarefaQuadroDTO(
        Long idtarefa,
        String desctarefa,

        Long idestoria,
        String descestoria,

        Long idepico,
        String nomeepico,
        String corepico,

        Long idstatus,
        String descstatus,
        String corstatus,

        Long idresponsavel,
        String nomeresponsavel
) {}