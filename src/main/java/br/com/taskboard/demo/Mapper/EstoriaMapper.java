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
        return dto;
    }
}
