package br.com.taskcontroller.Record;

import java.time.LocalDate;

public record EmpreendimentoDTO(
        Long idempreendimento,
        String descempreendimento,
        LocalDate data_inicio,
        LocalDate data_cadastro,
        LocalDate data_fim,
        String status,
        String cor,
        Long percentual
        ) {
}
