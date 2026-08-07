package br.com.taskcontroller.Modelo;

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

    @Column(name = "alterasenha")
    private boolean alterasenha;

    @Column(name = "ativo")
    private boolean ativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idempreendimento")
    private Empreendimento empreendimento;

    // Getters e Setters

    public Usuario() {

    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public boolean isAlterasenha() {
        return alterasenha;
    }

    public void setAlterasenha(boolean alterasenha) {
        this.alterasenha = alterasenha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Empreendimento getEmpreendimento() {
        return empreendimento;
    }

    public void setEmpreendimento(Empreendimento empreendimento) {
        this.empreendimento = empreendimento;
    }
}