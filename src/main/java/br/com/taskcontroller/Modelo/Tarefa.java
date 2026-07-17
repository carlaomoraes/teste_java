package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtarefa;
    private String desctarefa;
    @Column(name = "status", length = 20)
    private String status;
    @ManyToOne
    @JoinColumn(name = "idestoria")
    private Estoria estoria;
    @ManyToOne
    @JoinColumn(name="criador")
    private Usuario criador;
    @ManyToOne
    @JoinColumn(name="responsavel")
    private Usuario responsavel;
    @Column(name = "horas_estimadas")
    private Long horas_estimadas;
    @Column(name = "horas_gastas")
    private Long horas_gastas;
    @Column(name = "bloqueada")
    private boolean bloqueada;
    private LocalDate data_inicio;
    private LocalDate data_fim_prevista;
    private LocalDate data_conlusao;
    private int ativa;
    @ManyToOne
    @JoinColumn(name="idtipo_tarefa")
    private TipoTarefa tipoTarefa;
}
