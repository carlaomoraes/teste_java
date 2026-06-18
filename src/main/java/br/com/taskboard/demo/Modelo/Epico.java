package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Epico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idepico")
    private Long idepico;
    @Column(name = "descepico")
    private String descepico;
    @Column(name = "obsepico")
    private String obsepico;
    @Column(name = "bloqueado")
    private int bloqueado;
}
