package br.com.taskcontroller.Record.Equipe;

public record EquipeCardDTO(
        Long idEquipe,
        String nomeEquipe,
        Long historias,
        Long tarefa,
        Long horasEstimadas,
        Long horasRealizadas,
        Long custoRealizado
) {}