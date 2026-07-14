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
    private Long idsprint;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idempreendimento", nullable = false)
    private Empreendimento empreendimento;
    private String descsprint;
    private LocalDate dtiniciosprint;
    private LocalDate dtfinalsprint;
    private boolean visivel;
    private boolean ativa;
    private LocalDate dtterminosprint;
}
