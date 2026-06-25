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
        e.setIdempreendimento(dto.getIdempreendimento());
        e.setDescempreendimento(dto.getDescempreendimento());
        e.setData_inicio(dto.getData_inicio());
        e.setData_fim(dto.getData_fim());
        e.setSiglaempreendimento(dto.getSiglaempreendimento());
        e.setData_cadastro(dto.getData_cadastro());
        e.setIdgestor(dto.getIdgestor());
        return e;
    }

    public static EmpreendimentoResponseDTO toDTO(Empreendimento e) {
        EmpreendimentoResponseDTO dto = new EmpreendimentoResponseDTO();
        dto.setIdempreendimento(e.getIdempreendimento());
        dto.setDescempreendimento(e.getDescempreendimento());
        dto.setData_inicio(e.getData_inicio());
        dto.setData_fim(e.getData_fim());
        dto.setSiglaempreendimento(e.getSiglaempreendimento());
        dto.setData_cadastro(e.getData_cadastro());
        dto.setIdgestor(e.getIdgestor());
        return dto;
    }
}
