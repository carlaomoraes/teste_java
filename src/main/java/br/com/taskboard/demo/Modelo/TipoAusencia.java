package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class TipoAusencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_ausencia;
    @Column(name="desc_tipo_ausencia")
    private String desc_tipo_ausencia;
}
