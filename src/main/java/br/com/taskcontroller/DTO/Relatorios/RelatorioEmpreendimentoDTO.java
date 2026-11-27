package br.com.taskcontroller.DTO.Relatorios;

import java.math.BigDecimal;

public record RelatorioEmpreendimentoDTO(
        Long idempreendimento,
        String descempreendimento,
        Long contepico,
        Long contestoria,
        Long conttarefa,
        Long totalHorasEstimadas,
        Long totalHorasRealizadas,
        String totalHorasEstimadas60,
        String totalHorasRealizadas60,
        Long Saldo,
        String Saldo60
)
{
}
