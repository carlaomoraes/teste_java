package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.SprintEstoriaRequestDTO;
import br.com.taskcontroller.DTO.SprintEstoriaResponseDTO;
import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Modelo.SprintEstoria;

public class SprintEstoriaMapper {

    public static SprintEstoria toEntity(SprintEstoriaRequestDTO dto){
        SprintEstoria s = new SprintEstoria();
        s.setDataplanejamento(dto.getDataplanejamento());
        Sprint sprint = new Sprint();
        sprint.setIdsprint(dto.getIdsprint());
        s.setSprint(sprint);
        Estoria estoria = new Estoria();
        estoria.setIdestoria(dto.getIdestoria());
        estoria.setPontos(dto.getPontos());
        estoria.setHoras_estimadas(dto.getHorasestimadas());
        s.setEstoria(estoria);
        return s;
    }
    public static SprintEstoriaResponseDTO toDTO(SprintEstoria s) {
        SprintEstoriaResponseDTO dto = new SprintEstoriaResponseDTO();
        dto.setIdsprintEstoria(s.getIdsprintEstoria());
        dto.setSprint(s.getSprint());
        dto.setEstoria(s.getEstoria());
        dto.setDataplanejamento(s.getDataplanejamento());
        return dto;
    }
}
