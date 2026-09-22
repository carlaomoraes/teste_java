package br.com.taskcontroller.Record.Epico;

import java.time.LocalDate;
public record EpicoListagemDTO(
        Long percentual,
        Long idepico,
        String codepico,
        String nome,
        Long idempreendimento,
        String descempreendimento,
        Long idstatus,
        String descstatus,
        String corstatus,
        Long idprioridade,
        String descprioridade,
        String corprioridade,
        LocalDate data_inicialEP,
        LocalDate data_fim_previstaEP,
        String cor
) {
}