package br.com.taskboard.demo.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Prioridade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idprioridade;
    private String descprioridade;
}
