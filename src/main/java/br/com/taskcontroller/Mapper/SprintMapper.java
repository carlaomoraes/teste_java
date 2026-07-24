package br.com.taskcontroller.Mapper;


import br.com.taskcontroller.DTO.SprintRequestDTO;
import br.com.taskcontroller.DTO.SprintResponseDTO;
import br.com.taskcontroller.Modelo.Sprint;

public class SprintMapper {

    public static Sprint toEntity(SprintRequestDTO dto) {
        Sprint s = new Sprint();
        s.setIdsprint(dto.getIdsprint());
        s.setDescsprint(dto.getDescsprint());
        s.setDtiniciosprint(dto.getDtiniciosprint());
        s.setDtfinalsprint(dto.getDtfinalsprint());
        s.setVisivel(dto.isVisivel());
        s.setAtiva(dto.isAtiva());
        return s;
    }

    public static SprintResponseDTO toDTO(Sprint s) {
        SprintResponseDTO dto = new SprintResponseDTO();
        dto.setIdsprint(s.getIdsprint());
        dto.setDescsprint(s.getDescsprint());
        dto.setDtiniciosprint(s.getDtiniciosprint());
        dto.setDtfinalsprint(s.getDtfinalsprint());
        dto.setVisivel(s.isVisivel());
        dto.setAtiva(s.isAtiva());
        return dto;
    }
}
