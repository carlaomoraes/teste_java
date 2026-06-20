package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "equipe_usuario")
public class EquipeUsuario {

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idequipe")
    private Equipe equipe;

    // getters e setters
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}