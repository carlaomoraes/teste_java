package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.StatusTransicaoRequestDTO;
import br.com.taskcontroller.DTO.StatusTransicaoResponseDTO;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.StatusTransicao;
import br.com.taskcontroller.Service.StatusEntidadesService;
import org.springframework.beans.factory.annotation.Autowired;

public class StatusTransicaoMapper {
    @Autowired
    private static StatusEntidadesService statusEntidadesService;

    public static StatusTransicao toEntity(StatusTransicaoRequestDTO dto) {
        StatusTransicao s = new StatusTransicao();
        s.setIdtransicao(dto.getIdtransicao());
        StatusEntidades origem = statusEntidadesService.buscarPorId(dto.getStatusOrigem());
        s.setStatusOrigem(origem);
        StatusEntidades destino = statusEntidadesService.buscarPorId(dto.getStatusDestino());
        s.setStatusOrigem(destino);
        return s;
    }

    public static StatusTransicaoResponseDTO toDTO(StatusTransicao s) {
        StatusTransicaoResponseDTO dto = new StatusTransicaoResponseDTO();
        dto.setIdtransicao(s.getIdtransicao());
        dto.setStatusDestino(s.getStatusDestino().getIdstatus());
        dto.setStatusOrigem(s.getStatusOrigem().getIdstatus());
        return dto;
    }
}
