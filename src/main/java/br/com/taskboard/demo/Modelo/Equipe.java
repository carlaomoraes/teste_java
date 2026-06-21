package br.com.taskboard.demo.Modelo;

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

    private String nomeequipe;

    private String descequipe;
//
//    @OneToMany(mappedBy = "equipe")
//    private List<EquipeUsuario> membros;

    private String ativa;
}