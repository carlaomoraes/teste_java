package br.com.taskcontroller.Record.Estoria;

import br.com.taskcontroller.Enums.TipoAlteracao;

import java.time.LocalDateTime;

public record EstoriaHistoricoDTO(
        Long idhistorico,
        Long idestoria,
        Long idusuario,
        String nomeusuario,
        LocalDateTime data_alteracao,
        TipoAlteracao tipoalteracao,
        String valoranterior,
        String valornovo,
        String descricao
) {}