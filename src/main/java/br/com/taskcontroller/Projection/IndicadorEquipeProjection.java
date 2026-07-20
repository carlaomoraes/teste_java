package br.com.taskcontroller.Projection;

public interface IndicadorEquipeProjection {

    Long getIdEquipe();

    String getNomeEquipe();

    Long getTotalEstorias();

    Long getTotalTarefas();

    Double getHorasEstimadas();

    Double getHorasRealizadas();

    Double getCustoEstimado();

    Double getCustoRealizado();
}