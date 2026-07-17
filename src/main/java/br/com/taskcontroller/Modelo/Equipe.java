package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idequipe;

    @Column(name="nomeequipe")
    private String nomeequipe;

    @Column(name="descequipe")
    private String descequipe;

    @Column(name="ativa")
    private String ativa;
}