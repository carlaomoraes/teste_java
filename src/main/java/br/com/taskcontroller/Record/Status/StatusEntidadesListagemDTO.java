package br.com.taskcontroller.Record.Status;

public record StatusEntidadesListagemDTO(
        Long idstatus,
        Long idempreendimento,
        String descstatus,
        int ordem,
        String cor,
        int inicial,
        int finalizado,
        int cancelado,
        int ativo,
        Long idtipo_entidade,
        String desctipo_entidade
) {
}
