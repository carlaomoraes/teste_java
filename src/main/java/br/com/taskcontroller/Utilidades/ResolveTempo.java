package br.com.taskcontroller.Utilidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalTime;

public class ResolveTempo {

    // LocalTime para segundos
    public int transformarToDecimal(LocalTime horas) {
        if (horas == null) {
            return 0;
        }

        return horas.toSecondOfDay();
    }

    // Segundos para duração
    public Duration transformarToDuracao(long segundos) {
        return Duration.ofSeconds(segundos);
    }

    // Segundos para HH:mm:ss
    public String transformarToSexagesimal(long segundos) {

        long h = segundos / 3600;
        long m = (segundos % 3600) / 60;
        long s = segundos % 60;

        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public BigDecimal transformarParaHorasDecimais(
            BigDecimal segundos) {

        if (segundos == null) {
            return BigDecimal.ZERO;
        }

        return segundos.divide(
                BigDecimal.valueOf(3600),
                2,
                RoundingMode.HALF_UP
        );
    }
}
