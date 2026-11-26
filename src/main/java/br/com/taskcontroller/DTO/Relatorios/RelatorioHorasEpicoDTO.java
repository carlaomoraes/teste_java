package br.com.taskcontroller.DTO.Relatorios;

import lombok.Data;

import java.util.List;

@Data
public class RelatorioHorasEpicoDTO {
    Long idepico;
    String descepico;
    RelatorioTotalHorasDTO total;

    List<RelatorioHorasEstoriasDTO> estorias;


    public RelatorioHorasEpicoDTO(Long idepico, String descepico, RelatorioTotalHorasDTO total, List<RelatorioHorasEstoriasDTO> estorias) {
        this.idepico = idepico;
        this.descepico = descepico;
        this.total = total;
        this.estorias = estorias;
    }
}
