package br.com.taskcontroller.Record.Tarefa;

import br.com.taskcontroller.Enums.TipoAlteracao;

import java.time.LocalDateTime;

public record TarefaHistoricoDTO(
        Long idhistorico,
        Long idtarefa,
        Long idusuario,
        String nomeUsuario,
        LocalDateTime dataAlteracao,
        TipoAlteracao tipoAlteracao,
        String valorAnterior,
        String valorNovo,
        String descricao
) {}