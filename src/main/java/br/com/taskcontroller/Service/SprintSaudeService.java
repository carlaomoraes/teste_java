package br.com.taskcontroller.Service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SprintSaudeService {

    public String calcularSaude(
            Long TotalTarefa,
            BigDecimal progressoEsperado,
            BigDecimal progressoReal,
            BigDecimal desvioPercentual) {

        if (TotalTarefa == 0) {
            return "SEM_PLANEJAMENTO";
        }

        BigDecimal atraso =
                progressoEsperado.subtract(progressoReal);

        if (atraso.compareTo(
                BigDecimal.valueOf(25)) > 0
                || desvioPercentual.compareTo(
                BigDecimal.valueOf(30)) > 0) {
            return "CRITICA";
        }

        if (atraso.compareTo(
                BigDecimal.valueOf(10)) > 0
                || desvioPercentual.compareTo(
                BigDecimal.valueOf(15)) > 0) {
            return "ATENCAO";
        }

        return "SAUDAVEL";
    }
}