package br.com.taskcontroller.Record.Tarefa;

import java.time.LocalDate;

public record TarefaInclusaoDTO(
     Long idtarefa,
     String desctarefa,
     Long idstatus,
     Long idestoria,
     Long idcriador,
     Long idresponsavel,
     Long horas_estimadas,
     Long horas_realizadas,
     boolean bloqueada,
     LocalDate data_inicio,
     LocalDate data_fim_prevista,
     LocalDate data_conclusao,
     Long  idtipotarefa
) {
}
