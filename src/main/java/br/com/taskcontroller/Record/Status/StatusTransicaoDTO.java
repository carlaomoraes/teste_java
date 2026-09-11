package br.com.taskcontroller.Record.Status;

public record StatusTransicaoDTO(
        Long idstatus,
        String descstatus,
        boolean ativo,
        int ordem
) {
}
