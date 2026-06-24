package br.com.taskboard.demo.Mapper;

import br.com.taskboard.demo.DTO.EpicoRequestDTO;
import br.com.taskboard.demo.DTO.EpicoResponseDTO;
import br.com.taskboard.demo.Modelo.Epico;

public class EpicoMapper {

    public static Epico toEntity(EpicoRequestDTO dto) {
        Epico e = new Epico();
        e.setDescepico(dto.getDescepico());
        e.setObsepico(dto.getObsepico());
        e.setBloqueado(dto.getBloqueado());
        return e;
    }

    public static EpicoResponseDTO toDTO(Epico e) {
        EpicoResponseDTO dto = new EpicoResponseDTO();
        dto.setIdepico(e.getIdepico());
        dto.setDescepico(e.getDescepico());
        dto.setObsepico(e.getObsepico());
        dto.setBloqueado(e.getBloqueado());
        return dto;
    }
}
