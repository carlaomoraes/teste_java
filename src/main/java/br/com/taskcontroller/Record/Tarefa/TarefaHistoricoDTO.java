package br.com.taskcontroller.Record.Tarefa;

import br.com.taskcontroller.Enums.TipoAlteracao;

import java.time.LocalDateTime;

public record TarefaHistoricoDTO(
        Long idhistorico,
        Long idtarefa,
        Long idusuario,
        String nomeusuario,
        LocalDateTime data_alteracao,
        TipoAlteracao tipoalteracao,
        String valoranterior,
        String valornovo,
        String descricao
) {}