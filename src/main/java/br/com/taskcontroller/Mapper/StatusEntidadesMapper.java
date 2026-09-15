package br.com.taskcontroller.Mapper;


import br.com.taskcontroller.DTO.StatusEntidadesRequestDTO;
import br.com.taskcontroller.DTO.StatusEntidadesResponseDTO;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.TipoEntidade;

public class StatusEntidadesMapper {

    public static StatusEntidades toEntity(StatusEntidadesRequestDTO dto) {
        StatusEntidades s = new StatusEntidades();
        TipoEntidade t = new TipoEntidade();
        t.setIdtipo_entidade(dto.getIdtipoentidade());
        s.setTipoentidade(t);
        s.setDescstatus(dto.getDescstatus());
        s.setOrdem(dto.getOrdem());
        s.setCor(dto.getCor());
        s.setInicial(dto.isInicial());
        s.setFinalizado(dto.isFinalizado());
        s.setCancelado(dto.isCancelado());
        s.setAtivo(dto.isAtivo());
        return s;
    }

    public static StatusEntidadesResponseDTO toDTO(StatusEntidades s) {
        StatusEntidadesResponseDTO dto = new StatusEntidadesResponseDTO();
        dto.setIdstatus(s.getIdstatus());
        dto.setIdstatus(s.getIdstatus());
        dto.setDescstatus(s.getDescstatus());
        dto.setOrdem(s.getOrdem());
        dto.setCor(s.getCor());
        dto.setInicial(s.isInicial());
        dto.setFinalizado(s.isFinalizado());
        dto.setCancelado(s.isCancelado());
        dto.setAtivo(s.isAtivo());
        return dto;
    }
}
