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
        s.setDtterminosprint(dto.getDtterminosprint());
        s.setDtfinalsprint(dto.getDtfinalsprint());
        s.setVisivel(dto.isVisivel());
        s.setAtiva(dto.isAtiva());
        s.setDtterminosprint(dto.getDtterminosprint());
        return s;
    }

    public static SprintResponseDTO toDTO(Sprint e) {
        SprintResponseDTO dto = new SprintResponseDTO();
        dto.setIdsprint(e.getIdsprint());
        dto.setDescsprint(e.getDescsprint());
        dto.setDtiniciosprint(e.getDtiniciosprint());
        dto.setDtterminosprint(e.getDtterminosprint());
        return dto;
    }
}
