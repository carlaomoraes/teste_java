package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StatusEntidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idstatus;
    private String descstatus;
}
