package br.com.taskcontroller.Mapper;


import br.com.taskcontroller.DTO.EstoriaResponseDTO;
import br.com.taskcontroller.DTO.EstoriaResquestDTO;
import br.com.taskcontroller.Modelo.Estoria;

public class EstoriaMapper {

    public static Estoria toEntity(EstoriaResquestDTO dto) {
        Estoria e = new Estoria();
        e.setIdestoria(dto.getIdestoria());
        e.setDescestoria(dto.getDescestoria());
        e.setIdepico(dto.getIdepico());
        e.setIdcriador(dto.getIdcriador());
        e.setIdresponsavel(dto.getIdresponsavel());
        e.setBloqueada(dto.getBloqueada());
        e.setStatus(dto.getStatus());
        e.setResumo(dto.getResumo());
        e.setData_inicio(dto.getData_inicio());
        e.setData_fim(dto.getData_fim());
        e.setPontos(dto.getPontos());
        e.setAtiva(dto.getAtiva());
        e.setEmpreendimento_Equipe(dto.getEmpreendimento_Equipe());
        return e;
    }

    public static EstoriaResponseDTO toDTO(Estoria e) {
        EstoriaResponseDTO dto = new EstoriaResponseDTO();
        dto.setIdestoria(e.getIdestoria());
        dto.setDescestoria(e.getDescestoria());
        dto.setIdepico(e.getIdepico());
        dto.setIdcriador(e.getIdcriador());
        dto.setIdresponsavel(e.getIdresponsavel());
        dto.setBloqueada(e.getBloqueada());
        dto.setIdestoria(e.getIdestoria());
        dto.setStatus(e.getStatus());
        dto.setResumo(e.getResumo());
        dto.setData_inicio(e.getData_inicio());
        dto.setData_fim(e.getData_fim());
        dto.setPontos(e.getPontos());
        dto.setAtiva(e.getAtiva());
        dto.setEmpreendimento_Equipe(e.getEmpreendimento_Equipe());
        return dto;
    }
}
