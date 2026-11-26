package br.com.taskcontroller.DTO.Relatorios;

public record RelatorioHorasTarefaDTO(
        Long idsprint,
        String descsprint,
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
        Long Saldo,
        String Saldo60,
        int totalizacaoTarefa){

}
