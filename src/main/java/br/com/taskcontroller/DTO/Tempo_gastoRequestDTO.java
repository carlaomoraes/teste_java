package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Tarefa;
import br.com.taskcontroller.Modelo.Usuario;
import java.time.LocalDate;
import java.time.LocalTime;

public class Tempo_gastoRequestDTO {
    private Long idtempo_gasto;
    private Tarefa tarefa;
    private Usuario usuario;
    private LocalDate data_execucao;
    private LocalTime hora_execucaoo;
    private Long duracao; // Geralmente guardado em minutos ou horas inteiras
}