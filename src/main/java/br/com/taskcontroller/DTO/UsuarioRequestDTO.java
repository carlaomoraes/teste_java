package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.Papel;

public class UsuarioRequestDTO {
    private Long idusuario;
    private String nome;
    private String login;
    private String email;
    private String senha;
    private Long idpapel;
    private boolean alterasenha;
    private boolean ativo;

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

    public Long getIdpapel() {
        return idpapel;
    }

    public void setIdpapel(Long idpapel) {
        this.idpapel = idpapel;
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
}