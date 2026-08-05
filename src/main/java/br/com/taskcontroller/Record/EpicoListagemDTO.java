package br.com.taskcontroller.Record;

import java.time.LocalDate;
public record EpicoListagemDTO(
        Double percentual,
        Long idepico,
        String codepico,
        String nome,
        Long idempreendimento,
        String descempreendimento,
        String descstatus,
        String descprioridade,
        LocalDate data_inicio,
        LocalDate data_fim_prevista,
        String cor
) {
}