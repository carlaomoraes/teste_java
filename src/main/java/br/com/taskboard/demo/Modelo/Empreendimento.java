package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Empreendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idempreendimento;
    private String descempreendimento;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private LocalDate data_cadastro;
    @ManyToOne
    @JoinColumn(name = "idstatus")
    private Status idstatus;
    private String siglaempreendimento;
    @ManyToOne
    @JoinColumn(name = "idgestor")
    private Usuario idgestor;

}
