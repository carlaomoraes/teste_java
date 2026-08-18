package br.com.taskcontroller.Record.Ausencia;

import java.time.LocalDate;

public record AusenciaListagemDTO(
        Long idausencia,
        Long idusuario,
        String nome,
        LocalDate data_cadastro,
        LocalDate data_inicio,
        LocalDate data_fim,
        String observacao,
        String tipoausencia
        )
{
}
