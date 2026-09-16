package br.com.taskcontroller.Record.Status;

public record StatusTransicaoListagemDTO(
        Long idTransicao,
        Long idStatusOrigem,
        String statusOrigem,
        String corOrigem,
        Long idStatusDestino,
        String statusDestino,
        String corDestino
) {}