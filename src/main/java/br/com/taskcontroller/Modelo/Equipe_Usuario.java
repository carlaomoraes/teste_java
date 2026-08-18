package br.com.taskcontroller.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "equipe_usuario")
public class Equipe_Usuario {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idequipeusuario;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    @JsonIgnoreProperties("membros")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idequipe")
    @JsonIgnoreProperties("equipes")
    private Equipe equipe;
}