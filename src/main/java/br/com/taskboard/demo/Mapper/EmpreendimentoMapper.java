package br.com.taskboard.demo.Mapper;

import br.com.taskboard.demo.DTO.AusenciaProgramadaRequestDTO;
import br.com.taskboard.demo.DTO.AusenciaProgramadaResponseDTO;
import br.com.taskboard.demo.DTO.EmpreendimentoResponseDTO;
import br.com.taskboard.demo.DTO.EmpreendimentoResquestDTO;
import br.com.taskboard.demo.Modelo.AusenciaProgramada;
import br.com.taskboard.demo.Modelo.Empreendimento;

public class EmpreendimentoMapper {

    public static Empreendimento toEntity(EmpreendimentoResquestDTO dto) {
        Empreendimento e = new Empreendimento();
        e.setIdeempreendimento(dto.getIdeempreendimento());
        e.setDescempreendimento(dto.getDescempreendimento());
        e.setData_inicio(dto.getData_inicio());
        e.setData_fim(dto.getData_fim());
        e.setSiglaempreendimento(dto.getSiglaempreendimento());
        return e;
    }

    public static EmpreendimentoResponseDTO toDTO(Empreendimento e) {
        EmpreendimentoResponseDTO dto = new EmpreendimentoResponseDTO();
        dto.setIdeempreendimento(e.getIdeempreendimento());
        dto.setDescempreendimento(e.getDescempreendimento());
        dto.setData_inicio(e.getData_inicio());
        dto.setData_fim(e.getData_fim());
        dto.setSiglaempreendimento(e.getSiglaempreendimento());
        return dto;
    }
}
