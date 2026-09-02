package br.com.taskcontroller.Record.Papel;

import java.math.BigDecimal;

public record PapelComboDTO(
        Long idpapel,
        String descpapel,
        BigDecimal valorhora,
        boolean ativo,
        int tipopapel   ) {
}
