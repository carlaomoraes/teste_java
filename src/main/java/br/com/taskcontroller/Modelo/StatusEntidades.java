package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StatusEntidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idstatus;
    private String descstatus;
    private int ordem;
    private String cor;
    private int inicial;
    private int finalizado;
    private int cancelado;
    private int ativo;
    @ManyToOne
    @JoinColumn(name = "idempreendimento")
    private Empreendimento empreendimento;

    public Long getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Long idstatus) {
        this.idstatus = idstatus;
    }

    public String getDescstatus() {
        return descstatus;
    }

    public void setDescstatus(String descstatus) {
        this.descstatus = descstatus;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getInicial() {
        return inicial;
    }

    public void setInicial(int inicial) {
        this.inicial = inicial;
    }

    public int getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(int finalizado) {
        this.finalizado = finalizado;
    }

    public int getCancelado() {
        return cancelado;
    }

    public void setCancelado(int cancelado) {
        this.cancelado = cancelado;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public Empreendimento getEmpreendimento() {
        return empreendimento;
    }

    public void setEmpreendimento(Empreendimento empreendimento) {
        this.empreendimento = empreendimento;
    }}
