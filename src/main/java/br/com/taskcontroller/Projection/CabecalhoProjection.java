package br.com.taskcontroller.Projection;

import java.time.LocalDate;

public interface CabecalhoProjection {
    Long getIdSprint();
    Long getIdidempreendimento();
    LocalDate getDtiniciosprint();
    LocalDate getDtfinalsprint();
}
