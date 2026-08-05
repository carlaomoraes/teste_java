package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "estoria")
public class Estoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idestoria;

    private String descestoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcriador")
    private Usuario criador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idresponsavel")
    private Usuario responsavel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idepico")
    private Epico epico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idstatus")
    private StatusEntidades status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idempreendimento_equipe")
    private Empreendimento_Equipe empreendimentoEquipe;

    private boolean bloqueada;

    private String resumo;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    private Long pontos;

    private boolean ativa;

    public Long getIdestoria() {
        return idestoria;
    }

    public void setIdestoria(Long idestoria) {
        this.idestoria = idestoria;
    }

    public String getDescestoria() {
        return descestoria;
    }

    public void setDescestoria(String descestoria) {
        this.descestoria = descestoria;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Epico getEpico() {
        return epico;
    }

    public void setEpico(Epico epico) {
        this.epico = epico;
    }

    public StatusEntidades getStatus() {
        return status;
    }

    public void setStatus(StatusEntidades status) {
        this.status = status;
    }

    public Empreendimento_Equipe getEmpreendimentoEquipe() {
        return empreendimentoEquipe;
    }

    public void setEmpreendimentoEquipe(Empreendimento_Equipe empreendimentoEquipe) {
        this.empreendimentoEquipe = empreendimentoEquipe;
    }

    public boolean getBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Long getPontos() {
        return pontos;
    }

    public void setPontos(Long pontos) {
        this.pontos = pontos;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}