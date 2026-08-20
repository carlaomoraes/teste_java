package br.com.taskcontroller.Record.COMBO;

import java.math.BigDecimal;

public record PapelComboDTO(
        Long idpapel,
        String descpapel,
        BigDecimal valorhora) {
}
