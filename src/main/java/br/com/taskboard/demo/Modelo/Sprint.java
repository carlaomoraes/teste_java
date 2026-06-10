package br.com.taskboard.demo.Modelo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity

public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "sprint_seq",
            sequenceName = "sprint_sequence_table",
            allocationSize = 1
    )
    private Long idsprint;
    private String descsprint;
    private LocalDate dtiniciosprint;
    private LocalDate dtfinalsprint;
    private boolean visivel;
    private boolean ativa;


}
