package br.com.taskcontroller.Record.Estoria;

import java.time.LocalDate;

public record EstoriaRoadmapDTO(
        Long idestoria,
        String descestoria,
        Long idepico,
        String nome,
        String cor,
        String descsprint,
        LocalDate dtiniciosprint,
        LocalDate dtfinalsprint
) {
}