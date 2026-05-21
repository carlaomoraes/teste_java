package br.com.taskboard.demo.DTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Estoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstoria;
    private String descEstoria;
     private Long idEpico;
    private Long idusuario_criador;
    private Long idusuario_responsavel;

}
