package br.com.taskcontroller.Utilidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class ResolveTempo {
    public int transformarToDecimal(LocalTime horas) {
        if (horas == null) {
            return 0;
        }
        int h = horas.getHour();
        int m = horas.getMinute();
        int s = horas.getSecond();

        return (h * 3600) + (m * 60) + s;
    }
    public LocalTime transformarToSexagesimal(int horas) {
        if (horas == 0) {
            return LocalTime.of(0, 0);
        }
        int h = horas / 3600;
        int m = horas % 3600 / 60;
        int s = horas % 60;

        return LocalTime.of(h, m, s);
    }

}
