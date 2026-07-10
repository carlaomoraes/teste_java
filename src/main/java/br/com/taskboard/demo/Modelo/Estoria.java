package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Estoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idestoria;
    private String descestoria;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcriador")
    private Usuario idcriador;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idresponsavel")
    private Usuario idresponsavel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idepico")
    private Epico idepico;
    private Boolean bloqueada;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idstatus")
    private StatusEntidades status;
    private Blob resumo;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private Long pontos;
    private Long horas_estimadas;
    private Long horas_realizadas;
    private int ativa;
}
