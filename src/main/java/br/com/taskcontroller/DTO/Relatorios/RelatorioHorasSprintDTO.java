package br.com.taskcontroller.DTO.Relatorios;

import lombok.Data;

import java.util.List;

@Data
public class RelatorioHorasSprintDTO {
    Long idsprint;
    String descSprint;

    RelatorioTotalHorasDTO total;

    List<RelatorioHorasEpicoDTO> epicos;

    public RelatorioHorasSprintDTO(Long idsprint, String descSprint,
                                   RelatorioTotalHorasDTO total, List<RelatorioHorasEpicoDTO> epicos) {
        this.descSprint = descSprint;
        this.idsprint = idsprint;
        this.total = total;
        this.epicos = epicos;
    }
}
