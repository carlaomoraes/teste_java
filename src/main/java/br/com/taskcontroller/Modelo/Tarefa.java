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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idstatus")
    private StatusEntidades status;
    @ManyToOne
    @JoinColumn(name = "idestoria")
    private Estoria estoria;
    @ManyToOne
    @JoinColumn(name="idcriador")
    private Usuario criador;
    @ManyToOne
    @JoinColumn(name="idresponsavel")
    private Usuario responsavel;
    @Column(name = "horas_estimadas")
    private Long horas_estimadas;
    @Column(name = "horas_realizadas")
    private Long horas_realizadas;
    @Column(name = "bloqueada")
    private boolean bloqueada;
    @Column(name = "data_inicio")
    private LocalDate data_inicio;
    @Column(name = "data_fim_prevista")
    private LocalDate data_fim_prevista;
    @Column(name = "data_conclusao")
    private LocalDate data_conclusao;
    private int ativa;
    @ManyToOne
    @JoinColumn(name="idtipo_tarefa")
    private TipoTarefa tipoTarefa;
}
