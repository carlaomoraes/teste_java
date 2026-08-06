package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.*;
import br.com.taskcontroller.DTO.TarefaRequestDTO;
import br.com.taskcontroller.DTO.TarefaResponseDTO;
import br.com.taskcontroller.Modelo.Tarefa;

public class TarefaMapper {
    public static Tarefa toEntity(TarefaRequestDTO dto) {
        Tarefa t = new Tarefa();
        t.setIdtarefa(dto.getIdtarefa());
        t.setEstoria(dto.getEstoria());
        t.setStatus(dto.getEstoria().getStatus());
        t.setDesctarefa(dto.getDesctarefa());
        t.setCriador(dto.getCriador());
        t.setResponsavel(dto.getResponsavel());
        t.setHoras_estimadas(dto.getHoras_estimadas());
        t.setHoras_realizadas(dto.getHoras_estimadas());
        t.setIdtarefa(dto.getIdtarefa());
        t.setBloqueada(dto.isBloqueada());
        t.setData_fim_prevista(dto.getData_fim_prevista());
        t.setData_conclusao(dto.getData_conclusao());
        t.setData_inicio(dto.getData_inicio());
        t.setAtiva(dto.getAtiva());
        t.setTipotarefa(dto.getTipotarefa());
        return t;
    }

    public static TarefaResponseDTO toDTO(Tarefa t) {
        TarefaResponseDTO dto = new TarefaResponseDTO();
        dto.setIdtarefa(t.getIdtarefa());
        dto.setEstoria(t.getEstoria());
        dto.setStatus(t.getStatus());
        dto.setDesctarefa(t.getDesctarefa());
        dto.setCriador(t.getCriador());
        dto.setResponsavel(t.getResponsavel());
        dto.setHoras_estimadas(t.getHoras_estimadas());
        dto.setHoras_realizadas(t.getHoras_estimadas());
        dto.setIdtarefa(t.getIdtarefa());
        dto.setBloqueada(t.isBloqueada());
        dto.setData_fim_prevista(t.getData_fim_prevista());
        dto.setData_conclusao(t.getData_conclusao());
        dto.setData_inicio(t.getData_inicio());
        dto.setAtiva(t.getAtiva());
        dto.setTipoTarefa(t.getTipotarefa());
        return dto;
    }
}
