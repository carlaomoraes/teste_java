package br.com.taskcontroller.DTO.Relatorios;

import lombok.Data;

import java.util.List;

@Data
public class RelatorioHorasConsolidadoDTO {
    RelatorioTotalHorasDTO total;

    List<RelatorioHorasSprintDTO> sprints;

    public RelatorioHorasConsolidadoDTO(RelatorioTotalHorasDTO total, List<RelatorioHorasSprintDTO> sprints) {
        this.total = total;
        this.sprints = sprints;
    }
}
