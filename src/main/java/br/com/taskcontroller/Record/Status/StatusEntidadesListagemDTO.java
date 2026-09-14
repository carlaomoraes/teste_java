package br.com.taskcontroller.Record.Status;

public record StatusEntidadesListagemDTO(
        Long idstatus,
        String descstatus,
        int ordem,
        String cor,
        boolean inicial,
        boolean finalizado,
        boolean cancelado,
        boolean ativo,
        Long idtipo_entidade,
        String desctipo_entidade
) {
}
