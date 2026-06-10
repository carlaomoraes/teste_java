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
    private Long idestoria;
    private Long idusuario_criador;
    private Long idusuario_responsavel;
    @Column(name = "horas_estimadas")
    private Long horas_estimadas;
    @Column(name = "horas_gastas")
    private Long horas_gastas;
    @Column(name = "bloqueada")
    private boolean bloqueada;
}
