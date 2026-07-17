package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.EmpreendimentoRequestDTO;
import br.com.taskcontroller.DTO.EmpreendimentoResponseDTO;
import br.com.taskcontroller.Modelo.Empreendimento;

public class EmpreendimentoMapper {

    public static Empreendimento toEntity(EmpreendimentoRequestDTO dto) {
        Empreendimento e = new Empreendimento();
        e.setIdempreendimento(dto.getIdempreendimento());
        e.setDescempreendimento(dto.getDescempreendimento());
        e.setData_inicio(dto.getData_inicio());
        e.setData_fim(dto.getData_fim());
        e.setSiglaempreendimento(dto.getSiglaempreendimento());
        e.setData_cadastro(dto.getData_cadastro());
        e.setStatus(dto.getStatus());
        e.setIdgestor(dto.getIdgestor());
        e.setCor(dto.getCor());
        e.setPercentual(dto.getPercentual());
        e.setBloqueado(dto.isBloqueado());
        e.setCodempreendimento(dto.getCodempreendimento());
        e.setPrioridade(dto.getPrioridade());
        e.setAtivo(dto.getAtivo());
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
        dto.setStatus(e.getStatus());
        dto.setIdgestor(e.getIdgestor());
        dto.setCor(e.getCor());
        dto.setPercentual(e.getPercentual());
        dto.setBloqueado(e.isBloqueado());
        dto.setCodempreendimento(e.getCodempreendimento());
        dto.setPrioridade(e.getPrioridade());
        dto.setAtivo(e.getAtivo());
        return dto;
    }
}