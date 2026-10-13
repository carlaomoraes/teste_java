package br.com.taskcontroller.Record.Epico;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EpicoInclusaoDTO(
        Long idepico,
        Long idempreendimento,
        Long idresponsavel,
        Long idstatus,
        Long idprioridade,
        int bloqueado,
        LocalDate data_cadastro,
        LocalDate data_inicio,
        LocalDate data_fim_prevista,
        String codepico,
        String cor,
        BigDecimal percentual,
        int ativo,
        String nome
) {

}
