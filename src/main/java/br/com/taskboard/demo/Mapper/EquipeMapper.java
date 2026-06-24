package br.com.taskboard.demo.Mapper;


import br.com.taskboard.demo.DTO.EquipeRequestDTO;
import br.com.taskboard.demo.DTO.EquipeResponseDTO;
import br.com.taskboard.demo.Modelo.Equipe;

public class EquipeMapper {

    public static Equipe toEntity(EquipeRequestDTO dto) {
        Equipe e = new Equipe();
        e.setIdequipe(dto.getIdequipe());
        e.setNomeequipe(dto.getNomeequipe());
        e.setDescequipe(dto.getDescequipe());
        e.setAtiva(dto.getAtiva());
        return e;
    }

    public static EquipeResponseDTO toDTO(Equipe e) {
        EquipeResponseDTO dto = new EquipeResponseDTO();
        dto.setIdequipe(e.getIdequipe());
        dto.setNomeequipe(e.getNomeequipe());
        dto.setDescequipe(e.getDescequipe());
        dto.setAtiva(e.getAtiva());
        return dto;
    }
}
