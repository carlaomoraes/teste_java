package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Historico_sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idhistoricosprint ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idestoria")
    private Estoria estoria;
    private LocalDate dtiniciosprint;
    private LocalDate dtfinalsprint;
}
