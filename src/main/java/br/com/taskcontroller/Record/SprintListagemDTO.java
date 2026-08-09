package br.com.taskcontroller.Record;

import java.time.LocalDate;

public record SprintListagemDTO(
    Long idempreendimento,
    Long idsprint,
    String descsprint,
    LocalDate dtiniciosprint,
    LocalDate dtfinalsprint,
    boolean ativa,
    boolean visivel
)
{
}
