package br.com.taskcontroller.Record.Status;

public record TipoEntidadeDTO(
        Long idtipo_entidade,
        String desctipo_entidade,
        boolean ativo
) {
}
