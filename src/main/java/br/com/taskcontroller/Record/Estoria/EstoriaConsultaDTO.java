package br.com.taskcontroller.Record.Estoria;

import java.sql.Blob;
import java.time.LocalDate;

public record EstoriaConsultaDTO(
        Long idepico,
        Long idestoria,
        String descestoria,
        Long idstatus,
        String descstatus,
        Long idcriador,
        String nomecriador,
        Long idresponsavel,
        String nomeresponsavel,
        int pontos,
        Long horas_estimadas,
        Long horas_realizadas,
        LocalDate data_inicio,
        LocalDate data_fim,
        Boolean bloqueada,
        Blob resumo
) {
}