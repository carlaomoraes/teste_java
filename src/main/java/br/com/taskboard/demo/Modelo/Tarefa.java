package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtarefa;
    private String desctarefa;
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
}
