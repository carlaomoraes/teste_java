package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
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

    private Blob resumo;

    @Column(name = "data_inicio")
    private LocalDate data_inicio;

    @Column(name = "data_fim")
    private LocalDate data_fim;

    private int pontos;

    private boolean ativa;

    private Long horas_estimadas;

    private Long horas_realizadas;

    private String tags;

    private String criterios;

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

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public void setData_fim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Long getHoras_estimadas() {
        return horas_estimadas;
    }

    public void setHoras_estimadas(Long horas_estimadas) {
        this.horas_estimadas = horas_estimadas;
    }

    public Long getHoras_realizadas() {
        return horas_realizadas;
    }

    public void setHoras_realizadas(Long horas_realizadas) {
        this.horas_realizadas = horas_realizadas;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCriterios() {
        return criterios;
    }

    public void setCriterios(String criterios) {
        this.criterios = criterios;
    }

    public Blob getResumo() {
        return resumo;
    }

    public void setResumo(Blob resumo) {
        this.resumo = resumo;
    }
}