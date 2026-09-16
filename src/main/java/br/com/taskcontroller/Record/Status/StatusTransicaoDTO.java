package br.com.taskcontroller.Record.Status;

import br.com.taskcontroller.Modelo.StatusTransicao;

public record StatusTransicaoDTO(
        Long idstatus,
        String descstatus,
        boolean ativo,
        int ordem,
        String cor
) {
}
