package br.com.taskcontroller.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "empreendimento_equipe")
public class Empreendimento_Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idempreendimento_equipe;

    @ManyToOne
    @JoinColumn(name = "idempreendimento")
    @JsonIgnoreProperties("membros")
    private Empreendimento empreendimento;

    @ManyToOne
    @JoinColumn(name = "idequipe")
    @JsonIgnoreProperties("equipes")
    private Equipe equipe;
}