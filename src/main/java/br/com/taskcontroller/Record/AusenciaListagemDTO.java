package br.com.taskcontroller.Record;

import java.time.LocalDate;

public record AusenciaListagemDTO(
        Long idausencia,
        Long idusuario,
        LocalDate data_cadastro,
        LocalDate data_inicio,
        LocalDate data_fim,
        String observacao,
        Long idempreendimento,
        String tipoausencia
        )
{
}
