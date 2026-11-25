package br.com.taskcontroller.DTO.Relatorios;

import java.math.BigDecimal;

public record RelatorioHorasTarefaDTO(
        Long idsprint,
        Long idepico,
        String descepico,
        Long idestoria,
        String descestoria,
        Long idtarefa,
        String desctarefa,
        String responsavel,
        String descstatus,
        int totalHorasEstimadas,
        int totalHorasRealizadas,
        String totalHorasEstimadas60,
        String totalHorasRealizadas60,
        int Saldo,
        String Saldo60,
        int totalizacaoTarefa

)
{

}
