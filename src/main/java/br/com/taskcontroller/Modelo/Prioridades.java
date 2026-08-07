package br.com.taskcontroller.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Prioridades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idprioridade;
    private String descprioridade;
    private String corprioridade;
}
