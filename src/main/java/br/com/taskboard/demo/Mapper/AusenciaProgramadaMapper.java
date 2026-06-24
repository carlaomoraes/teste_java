package br.com.taskboard.demo.Mapper;

import br.com.taskboard.demo.DTO.AusenciaProgramadaRequestDTO;
import br.com.taskboard.demo.DTO.AusenciaProgramadaResponseDTO;
import br.com.taskboard.demo.Modelo.AusenciaProgramada;

public class AusenciaProgramadaMapper {

    public static AusenciaProgramada toEntity(AusenciaProgramadaRequestDTO dto) {
        AusenciaProgramada a = new AusenciaProgramada();
        a.setIdausencia(dto.getIdausencia());
        a.setIdusuario(dto.getIdusuario());
        a.setData_inicio(dto.getData_inicio());
        a.setData_fim(dto.getData_fim());
        a.setObservacao(dto.getObservacao());
        a.setStatus(dto.getStatus());
        a.setData_cadastro(dto.getData_cadastro());
        a.setTipoausencia(dto.getTipoausencia());

        return a;
    }

    public static AusenciaProgramadaResponseDTO toDTO(AusenciaProgramada a) {
        AusenciaProgramadaResponseDTO dto = new AusenciaProgramadaResponseDTO();
        dto.setIdausencia(a.getIdausencia());
        dto.setIdusuario(a.getIdusuario());
        dto.setData_inicio(a.getData_inicio());
        dto.setData_fim(a.getData_fim());
        dto.setObservacao(a.getObservacao());
        dto.setTipoausencia(a.getTipoausencia());
        dto.setStatus(a.getStatus());
        dto.setData_cadastro(a.getData_cadastro());
        dto.setData_inicio(a.getData_inicio());
        dto.setData_fim(a.getData_fim());
        dto.setObservacao(a.getObservacao());

        return dto;
    }
}
