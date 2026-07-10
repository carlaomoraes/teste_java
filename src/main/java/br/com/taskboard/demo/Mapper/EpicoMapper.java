package br.com.taskboard.demo.Mapper;

import br.com.taskboard.demo.DTO.EpicoRequestDTO;
import br.com.taskboard.demo.DTO.EpicoResponseDTO;
import br.com.taskboard.demo.Modelo.Epico;

public class EpicoMapper {

    public static Epico toEntity(EpicoRequestDTO dto) {
        Epico e = new Epico();
        e.setIdepico(dto.getIdepico());
        e.setEmpreendimento(dto.getEmpreendimento());
        e.setResponsavel(dto.getResponsavel());
        e.setPrioridade(dto.getPrioridade());
        e.setStatus(dto.getStatus());
        e.setBloqueado(dto.getBloqueado());
        e.setData_cadastro(dto.getData_cadastro());
        e.setData_inicio(dto.getData_inicio());
        e.setData_fim_prevista(dto.getData_fim_prevista());
        e.setCodepico(dto.getCodepico());
        e.setNome(dto.getNome());
        e.setCor(dto.getCor());
        e.setPercentual(dto.getPercentual());
        e.setAtivo(dto.getAtivo());
        return e;
    }

    public static EpicoResponseDTO toDTO(Epico e) {
        EpicoResponseDTO dto = new EpicoResponseDTO();
        dto.setIdepico(dto.getIdepico());
        dto.setEmpreendimento(dto.getEmpreendimento());
        dto.setResponsavel(dto.getResponsavel());
        dto.setPrioridade(dto.getPrioridade());
        dto.setStatus(dto.getStatus());
        dto.setBloqueado(e.getBloqueado());
        dto.setData_cadastro(dto.getData_cadastro());
        dto.setData_inicio(dto.getData_inicio());
        dto.setData_fim_prevista(dto.getData_fim_prevista());
        dto.setCodepico(dto.getCodepico());
        dto.setNome(dto.getNome());
        dto.setCor(dto.getCor());
        dto.setPercentual(dto.getPercentual());
        dto.setAtivo(dto.getAtivo());
        return dto;
    }
}
