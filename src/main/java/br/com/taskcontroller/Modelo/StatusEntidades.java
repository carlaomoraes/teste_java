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
    private boolean inicial;
    private boolean finalizado;
    private boolean cancelado;
    private boolean ativo;
    @ManyToOne
    @JoinColumn(name = "idempreendimento")
    private Empreendimento empreendimento;
    @ManyToOne
    @JoinColumn(name="idtipo_entidade")
    private TipoEntidade tipoentidade;

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

    public boolean isInicial() {
        return inicial;
    }

    public void setInicial(boolean inicial) {
        this.inicial = inicial;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
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

    public TipoEntidade getTipoentidade() {
        return tipoentidade;
    }

    public void setTipoentidade(TipoEntidade tipoentidade) {
        this.tipoentidade = tipoentidade;
    }
}
