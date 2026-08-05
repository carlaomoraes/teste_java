package br.com.taskcontroller.Record;

import java.time.LocalDate;

public record EstoriaConsultaDTO(
        Long idestoria,
        String descestoria,
        Long idstatus,
        String descstatus,
        Long idcriador,
        String nomecriador,
        Long idresponsavel,
        String nomeresponsavel,
        String resumo,
        Long pontos,
        Long horas_estimadas,
        Long horas_realizadas,
        LocalDate data_inicio,
        LocalDate data_fim,
        Boolean bloqueada
) {
}