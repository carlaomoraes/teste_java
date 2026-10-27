package br.com.taskcontroller.Record.Epico;

import br.com.taskcontroller.Enums.TipoAlteracao;

import java.time.LocalDateTime;

public record EpicoHistoricoDTO(
        Long idhistorico,
        Long idepico,
        Long idusuario,
        String nomeusuario,
        LocalDateTime data_alteracao,
        TipoAlteracao tipoalteracao,
        String valoranterior,
        String valornovo,
        String descricao
) {}