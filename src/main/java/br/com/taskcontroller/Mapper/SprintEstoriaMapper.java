package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.SprintEstoriaRequestDTO;
import br.com.taskcontroller.DTO.SprintEstoriaResponseDTO;
import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Modelo.SprintEstoria;

public class SprintEstoriaMapper {
    public static SprintEstoria toEntity(SprintEstoriaRequestDTO dto){
        SprintEstoria s = new SprintEstoria();
        s.setIdsprintEstoria(dto.getIdsprintEstoria());
        Sprint sprint = new Sprint();
        sprint.setIdsprint(dto.getIdsprintEstoria());
        s.setSprint(sprint);
        Estoria estoria = new Estoria();
        estoria.setIdestoria(dto.getEstoria().getIdestoria());
        s.setEstoria(estoria);
        s.setOrdem(dto.getOrdem());
        s.setDataplanejamento(dto.getDataplanejamento());
        return s;
    }
    public static SprintEstoriaResponseDTO toDTO(SprintEstoria s) {
        SprintEstoriaResponseDTO dto = new SprintEstoriaResponseDTO();
        dto.setIdsprintEstoria(s.getIdsprintEstoria());
        Sprint sprint = new Sprint();
        sprint.setIdsprint(s.getIdsprintEstoria());
        dto.setSprint(sprint);
        Estoria estoria = new Estoria();
        dto.setEstoria(estoria);
        dto.setOrdem(s.getOrdem());
        dto.setDataplanejamento(s.getDataplanejamento());
        return dto;
    }
}
