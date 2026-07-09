package br.com.taskboard.demo.Mapper;


import br.com.taskboard.demo.DTO.EstoriaResponseDTO;
import br.com.taskboard.demo.DTO.EstoriaResquestDTO;
import br.com.taskboard.demo.Modelo.Estoria;

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
        e.setHoras_estimadas(dto.getHoras_estimadas());
        e.setHoras_realizadas(dto.getHoras_realizadas());
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
        dto.setHoras_estimadas(e.getHoras_estimadas());
        dto.setHoras_realizadas(e.getHoras_realizadas());
        return dto;
    }
}
