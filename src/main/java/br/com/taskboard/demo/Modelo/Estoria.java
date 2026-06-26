package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private String status;
}
