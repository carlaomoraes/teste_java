package br.com.taskboard.demo.Modelo;

import br.com.taskboard.demo.Enums.Prioridades;
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
    @JoinColumn(name="idusuario_criador")
    private Usuario criador;
    @ManyToOne
    @JoinColumn(name="idusuario_responsavel")
    private Usuario responsavel;
    @Column(name = "horas_estimadas")
    private Long horas_estimadas;
    @Column(name = "horas_gastas")
    private Long horas_gastas;
    @Column(name = "bloqueada")
    private boolean bloqueada;
    private Prioridades prioridade;
    @Column(name = "pontos")
    private Long pontos;


}
