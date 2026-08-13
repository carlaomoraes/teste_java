package br.com.taskcontroller.Record.Epico;

import java.time.LocalDate;

public record EpicoConsultaDTO(
        Double percentual,
        Long idepico,
        String codepico,
        String nome,
        Long idempreendimento,
        String descempreendimento,
        Long idstatus,
        String descstatus,
        Long idprioridade,
        String descprioridade,
        LocalDate data_inicialEP,
        LocalDate data_fim_previstaEP,
        String cor,
        Long idcriador,
        String nomecriador
) {
}