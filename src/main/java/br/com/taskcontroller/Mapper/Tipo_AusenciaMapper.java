package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.TipoAusenciaRequestDTO;
import br.com.taskcontroller.DTO.TipoAusenciaResponseDTO;
import br.com.taskcontroller.Modelo.Tipo_Ausencia;

public class Tipo_AusenciaMapper {

    public static Tipo_Ausencia toEntity(TipoAusenciaRequestDTO dto) {
        Tipo_Ausencia t = new Tipo_Ausencia();
        t.setId_tipo_ausencia(dto.getId_tipo_ausencia());
        t.setDesc_tipo_ausencia(dto.getDesc_tipo_ausencia());
        t.setCor_tipo_ausencia(dto.getCor_tipo_ausencia());
        return t;
    }

    public static TipoAusenciaResponseDTO toDTO(Tipo_Ausencia t) {
        TipoAusenciaResponseDTO dto = new TipoAusenciaResponseDTO();
        dto.setId_tipo_ausencia(t.getId_tipo_ausencia());
        dto.setDesc_tipo_ausencia(t.getDesc_tipo_ausencia());
        dto.setCor_tipo_ausencia(t.getCor_tipo_ausencia());
        return dto;
    }
}
