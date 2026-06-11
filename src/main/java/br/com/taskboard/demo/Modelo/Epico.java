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
    private Long idepico;
    private String descepico;
    private String obsepico;
    private boolean bloqueado;
}
