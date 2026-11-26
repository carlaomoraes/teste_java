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
        String sinal = segundos < 0 ? "-" : "";

        long total = Math.abs(segundos);

        long h = total / 3600;
        long m = (total % 3600) / 60;
        long s = total % 60;

        return sinal + String.format("%02d:%02d:%02d", h, m, s);
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
