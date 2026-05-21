package br.com.taskboard.demo.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

}
