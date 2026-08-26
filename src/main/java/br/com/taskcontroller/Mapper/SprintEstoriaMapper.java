package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.SprintEstoriaRequestDTO;
import br.com.taskcontroller.DTO.SprintEstoriaResponseDTO;
import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Modelo.SprintEstoria;
import br.com.taskcontroller.Respository.AusenciaProgramadaRepository;
import br.com.taskcontroller.Respository.SprintEstoriaRepository;
import br.com.taskcontroller.Respository.SprintRepository;
import br.com.taskcontroller.Service.EmpreendimentoService;
import br.com.taskcontroller.Service.EstoriaService;
import br.com.taskcontroller.Service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;

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
