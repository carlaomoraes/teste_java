package br.com.taskcontroller.Mapper;


import br.com.taskcontroller.DTO.Sprint.SprintRequestDTO;
import br.com.taskcontroller.DTO.Sprint.SprintResponseDTO;
import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Service.SprintService;
import br.com.taskcontroller.Service.StatusEntidadesService;
import org.springframework.beans.factory.annotation.Autowired;


public class SprintMapper {

    @Autowired
    private static StatusEntidadesService statusEntidadesService;


    public static Sprint toEntity(SprintRequestDTO dto) {
        Sprint s = new Sprint();
        StatusEntidades status = statusEntidadesService.buscarPorId(dto.idstatus());

        s.setIdsprint(dto.idsprint());
        s.setDescsprint(dto.descsprint());
        s.setDtiniciosprint(dto.dtiniciosprint());
        s.setDtfinalsprint(dto.dtfinalsprint());
        s.setVisivel(dto.visivel());
        s.setStatus(status);
        return s;
    }

    public static SprintResponseDTO toDTO(Sprint s) {
        SprintResponseDTO dto = new SprintResponseDTO();
        dto.setIdsprint(s.getIdsprint());
        dto.setDescsprint(s.getDescsprint());
        dto.setDtiniciosprint(s.getDtiniciosprint());
        dto.setDtfinalsprint(s.getDtfinalsprint());
        dto.setVisivel(s.isVisivel());
        dto.setStatus(s.getStatus());
        return dto;
    }
}
