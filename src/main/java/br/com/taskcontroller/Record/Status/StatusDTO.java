package br.com.taskcontroller.Record.Status;

public record StatusDTO(
        Long idStatus,
        String descstatus,
        boolean ativo,
        String cor
) {
}
