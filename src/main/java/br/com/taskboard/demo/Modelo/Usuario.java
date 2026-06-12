package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    private boolean alteraSenha;

    // Getters e Setters

    public Usuario() {

    }
}