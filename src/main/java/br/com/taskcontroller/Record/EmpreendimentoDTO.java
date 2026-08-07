package br.com.taskcontroller.Record;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmpreendimentoDTO(
        Long idempreendimento,
        String descempreendimento,
        String siglaempreendimento,
        String codempreendimento,
        LocalDate data_cadastro,
        LocalDate data_inicio,
        LocalDate data_fim,
        Long idgestor,
        String nomegestor,
        String cor,
        BigDecimal percentual
) {
}
