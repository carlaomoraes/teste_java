package br.com.taskcontroller.DTO.Relatorios;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RelatorioHorasEstoriasDTO {
    Long idtarefa;
    Long idestoria;
    String descestoria;

    Long idepico;
    String descepico;

    int horasEstimadas;
    int horasRealizadas;
    BigDecimal saldo;
    BigDecimal desvioPorc;

    List<RelatorioHorasTarefaDTO> tarefas;

    public RelatorioHorasEstoriasDTO(Long idtarefa,
                                     Long idestoria,
                                     String descestoria,
                                     Long idepico,
                                     String descepico,
                                     int horasEstimadas,
                                     int horasRealizadas,
                                     BigDecimal saldo,
                                     BigDecimal desvioPorc,
                                     List<RelatorioHorasTarefaDTO> tarefas) {
        this.idtarefa = idtarefa;
        this.idestoria = idestoria;
        this.descestoria = descestoria;
        this.idepico = idepico;
        this.descepico = descepico;
        this.horasEstimadas = horasEstimadas;
        this.horasRealizadas = horasRealizadas;
        this.saldo = saldo;
        this.desvioPorc = desvioPorc;
        this.tarefas = tarefas;
    }
}
