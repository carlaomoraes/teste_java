package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "equipe_usuario")
public class EquipeUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipeUsuario;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idequipe")
    private Equipe equipe;

    // getters e setters
}