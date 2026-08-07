package br.com.taskcontroller.Record;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmpreendimentoDTO(
        Long idempreendimento,
        String descempreendimento,
        LocalDate data_inicio,
        LocalDate data_fim,
        LocalDate data_cadastro,
        String siglaempreendimento,
        int ativo,
        Long idstatus,
        String descstatus,
        Long idprioridade,
        String descprioridade,
        String corprioridade,
        String cor,
        Long percentual,
        Long idusuario,
        String nomme,
        int duracao_min_sprint,
        int duracao_max_sprint,
        int permitir_sprint_sobreposta,
        int permitir_multiplas_sprint_ativas,
        int horas_trabalho_dia,
        int considerar_feriados

) {
}
