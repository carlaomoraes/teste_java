package br.com.taskcontroller.Mapper;


import br.com.taskcontroller.DTO.EstoriaResponseDTO;
import br.com.taskcontroller.DTO.EstoriaResquestDTO;
import br.com.taskcontroller.Modelo.Estoria;

public class EstoriaMapper {

    public static Estoria toEntity(EstoriaResquestDTO dto) {
        Estoria e = new Estoria();
        e.setIdestoria(dto.getIdestoria());
        e.setDescestoria(dto.getDescestoria());
        e.setEpico(dto.getEpico());
        e.setCriador(dto.getCriador());
        e.setResponsavel(dto.getResponsavel());
        e.setBloqueada(dto.getBloqueada());
        e.setStatus(dto.getStatus());
        e.setResumo(dto.getResumo());
        e.setDataInicio(dto.getData_inicio());
        e.setDataFim(dto.getData_fim());
        e.setPontos(dto.getPontos());
        e.setAtiva(dto.getAtiva());
        e.setEmpreendimentoEquipe(dto.getEmpreendimentoEquipe());
        return e;
    }

    public static EstoriaResponseDTO toDTO(Estoria e) {
        EstoriaResponseDTO dto = new EstoriaResponseDTO();
        dto.setIdestoria(e.getIdestoria());
        dto.setDescestoria(e.getDescestoria());
        dto.setEpico(e.getEpico());
        dto.setCriador(e.getCriador());
        dto.setResponsavel(e.getResponsavel());
        dto.setBloqueada(e.getBloqueada());
        dto.setIdestoria(e.getIdestoria());
        dto.setStatus(e.getStatus());
        dto.setResumo(e.getResumo());
        dto.setData_inicio(e.getDataInicio());
        dto.setData_fim(e.getDataFim());
        dto.setPontos(e.getPontos());
        dto.setAtiva(e.getAtiva());
        dto.setEmpreendimentoEquipe(e.getEmpreendimentoEquipe());
        return dto;
    }
}
