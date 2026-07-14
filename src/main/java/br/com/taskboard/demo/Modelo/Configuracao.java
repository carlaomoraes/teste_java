package br.com.taskboard.demo.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "configuracao")
public class Configuracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idconfiguracao;
    private Long duracaominSprint;
    private Long duracaomaxSprint;
    private Boolean permitirSprintSobreposta;
    private Boolean permitirMultiplaSprintAtivas;
    private Long horasTrabalhoDia;
    private Boolean considerarFeriados;
}
