package br.com.taskcontroller.Record;

public record EquipeCardDTO(
        Long idEquipe,
        String nomeEquipe,
        Long historias,
        Long horasEstimadas,
        Long horasRealizadas
) {}