package br.com.taskcontroller.Record.Epico;

import java.time.LocalDate;

public record EpicoInclusaoDTO(
        String nome,
        Long idempreendimento,
        Long idresponsavel,
        Long idstatus,
        Long idprioridade,
        int bloqueado,
        LocalDate data_inicialEP,
        LocalDate data_fim_previstaEP,
        String codepico,
        String cor,
        Long percentual,
        int ativo
) {

}
