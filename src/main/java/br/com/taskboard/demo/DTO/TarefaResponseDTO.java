package br.com.taskboard.demo.DTO;

import br.com.taskboard.demo.Modelo.Estoria;
import br.com.taskboard.demo.Modelo.Status;
import br.com.taskboard.demo.Modelo.Usuario;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class TarefaResponseDTO {
    private Long idtarefa;
    private String desctarefa;
    @Column(name = "status", length = 20)
    private Status status;
    private Estoria estoria;
    private Usuario criador;
    private Usuario responsavel;
    private Long horas_estimadas;
    private Long horas_gastas;
    private boolean bloqueada;
    private LocalDate data_inicio;
    private LocalDate data_fim_prevista;
    private LocalDate data_conlusao;
}
