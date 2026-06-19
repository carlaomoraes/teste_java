package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    private String nome;

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String email;

    @Column(length = 100)
    private String senha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpapel")
    private Papel papel;

    @Column(name = "alterasenha")
    private int alterasenha;

    @OneToMany(mappedBy = "usuario")
    private List<EquipeUsuario> equipes;


    // Getters e Setters

    public Usuario() {

    }
}