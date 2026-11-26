package br.com.taskcontroller.DTO.Relatorios;

import lombok.Data;

import java.util.List;

@Data
public class RelatorioHorasConsolidadoDTO {
    RelatorioTotalHorasDTO total;

    public RelatorioHorasConsolidadoDTO(RelatorioTotalHorasDTO total) {
        this.total = total;
    }
}
