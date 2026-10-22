package br.com.taskcontroller.Mapper;


import br.com.taskcontroller.DTO.Equipe.EquipeRequestDTO;
import br.com.taskcontroller.DTO.Equipe.EquipeResponseDTO;
import br.com.taskcontroller.Modelo.Equipe;

public class EquipeMapper {

    public static Equipe toEntity(EquipeRequestDTO dto) {
        Equipe e = new Equipe();
        e.setIdequipe(dto.getIdequipe());
        e.setNomeequipe(dto.getNomeequipe());
        e.setDescequipe(dto.getDescequipe());
        e.setAtiva(dto.isAtiva());
        return e;
    }

    public static EquipeResponseDTO toDTO(Equipe e) {
        EquipeResponseDTO dto = new EquipeResponseDTO();
        dto.setIdequipe(e.getIdequipe());
        dto.setNomeequipe(e.getNomeequipe());
        dto.setDescequipe(e.getDescequipe());
        dto.setAtiva(e.isAtiva());
        return dto;
    }
}
