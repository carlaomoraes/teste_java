package br.com.taskcontroller.Record.Epico;

import java.math.BigDecimal;
import java.time.LocalDate;
public record EpicoListagemDTO(
        Long percentual,
        Long idepico,
        String codepico,
        String nome,
        Long idempreendimento,
        String descempreendimento,
        String descstatus,
        String descprioridade,
        String corprioridade,
        LocalDate data_inicio,
        LocalDate data_fim_prevista,
        String cor
) {
}