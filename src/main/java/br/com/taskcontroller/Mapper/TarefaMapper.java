package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.*;
import br.com.taskcontroller.DTO.TarefaResponseDTO;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Tarefa.TarefaInclusaoDTO;

public class TarefaMapper {
    public static Tarefa toEntity(TarefaInclusaoDTO dto) {
        Tarefa t = new Tarefa();
        Estoria estoria = new Estoria();
        estoria.setIdestoria(dto.idestoria());
        t.setEstoria(estoria);
        StatusEntidades status = new StatusEntidades();
        status.setIdstatus(dto.idstatus());
        t.setStatus(status);
        t.setDesctarefa(dto.desctarefa());
        Usuario criador = new Usuario();
        criador.setIdusuario(dto.idcriador());
        t.setCriador(criador);
        Usuario responsavel = new Usuario();
        responsavel.setIdusuario(dto.idresponsavel());
        t.setResponsavel(responsavel);
        t.setHoras_realizadas(dto.horas_realizadas());
        t.setHoras_estimadas(dto.horas_estimadas());
        TipoTarefa tipoTarefa = new TipoTarefa();
        tipoTarefa.setIdtipo_tarefa(dto.idtipotarefa());
        t.setTipotarefa(tipoTarefa);
        t.setBloqueada(dto.bloqueada());
        t.setData_fim_prevista(dto.data_fim_prevista());
        t.setData_conclusao(dto.data_conclusao());
        t.setData_inicio(dto.data_inicio());
        return t;
    }

    public static TarefaResponseDTO toDTO(Tarefa t) {
        TarefaResponseDTO dto = new TarefaResponseDTO();
        dto.setIdtarefa(t.getIdtarefa());
        dto.setDesctarefa(t.getDesctarefa());
        dto.setEstoria(t.getEstoria());
        dto.setStatus(t.getStatus());
        dto.setCriador(t.getCriador());
        dto.setResponsavel(t.getResponsavel());
        dto.setHoras_realizadas(t.getHoras_realizadas());
        dto.setHoras_estimadas(t.getHoras_estimadas());
        dto.setTipoTarefa(t.getTipotarefa());
        dto.setBloqueada(t.isBloqueada());
        dto.setData_fim_prevista(t.getData_fim_prevista());
        dto.setData_conclusao(t.getData_conclusao());
        dto.setData_inicio(t.getData_inicio());

        return dto;
    }
}
