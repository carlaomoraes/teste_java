package br.com.taskcontroller.Mapper;


import br.com.taskcontroller.DTO.Etapa_sistemaResponseDTO;
import br.com.taskcontroller.DTO.Etapa_sistemaResquestDTO;
import br.com.taskcontroller.Modelo.Etapa_sistema;

public class EtapaMapper {

    public static Etapa_sistema toEntity(Etapa_sistemaResquestDTO dto) {
        Etapa_sistema e = new Etapa_sistema();
        e.setIdetapa_sistema(dto.getIdetapa_sistema());
        e.setDescetapa_sistema(dto.getDescetapa_sistema());
        e.setIdetapa_sistema(e.getIdetapa_sistema());
        e.setBacklog(dto.getBacklog());
        return e;
    }

    public static Etapa_sistemaResponseDTO toDTO(Etapa_sistema e) {
        Etapa_sistemaResponseDTO dto = new Etapa_sistemaResponseDTO();
        dto.setIdetapa_sistema(e.getIdetapa_sistema());
        dto.setDescetapa_sistema(e.getDescetapa_sistema());
        dto.setIdetapa_sistema(e.getIdetapa_sistema());
        dto.setBacklog(e.getBacklog());
        return dto;
    }
}
