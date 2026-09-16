package br.com.taskcontroller.Record.Status;

public record StatusDTO(
        Long idstatus,
        String descstatus,
        boolean ativo,
        String cor
) {
}
