package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "configuracao")
public class Configuracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idconfiguracao")
    private Long idconfiguracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idempreendimento", nullable = false)
    private Empreendimento empreendimento;

    @Column(name = "duracao_min_sprint", nullable = false)
    private Integer duracao_min_sprint;

    @Column(name = "duracao_max_sprint", nullable = false)
    private Integer duracao_max_sprint;

    @Column(name = "permitir_sprint_sobreposta", nullable = false)
    private Boolean permitir_sprint_sobreposta = false;

    @Column(name = "permitir_multiplas_sprint_ativas", nullable = false)
    private Boolean permitir_multiplas_sprint_ativas = false;

    @Column(name = "horas_trabalho_dia", nullable = false)
    private Integer horas_trabalho_dia = 8;

    @Column(name = "considerar_Feriados", nullable = false)
    private Boolean considerar_Feriados = true;

    @Column(name = "considerar_valorhoras", nullable = false)
    private Boolean considerar_valorhoras = false;


    public Long getIdconfiguracao() {
        return idconfiguracao;
    }

    public void setIdconfiguracao(Long idconfiguracao) {
        this.idconfiguracao = idconfiguracao;
    }

    public Empreendimento getEmpreendimento() {
        return empreendimento;
    }

    public void setEmpreendimento(Empreendimento empreendimento) {
        this.empreendimento = empreendimento;
    }

    public Integer getDuracao_min_sprint() {
        return duracao_min_sprint;
    }

    public void setDuracao_min_sprint(Integer duracao_min_sprint) {
        this.duracao_min_sprint = duracao_min_sprint;
    }

    public Integer getDuracao_max_sprint() {
        return duracao_max_sprint;
    }

    public void setDuracao_max_sprint(Integer duracao_max_sprint) {
        this.duracao_max_sprint = duracao_max_sprint;
    }

    public Boolean getPermitir_sprint_sobreposta() {
        return permitir_sprint_sobreposta;
    }

    public void setPermitir_sprint_sobreposta(Boolean permitir_sprint_sobreposta) {
        this.permitir_sprint_sobreposta = permitir_sprint_sobreposta;
    }

    public Boolean getPermitir_multiplas_sprint_ativas() {
        return permitir_multiplas_sprint_ativas;
    }

    public void setPermitir_multiplas_sprint_ativas(Boolean permitir_multiplas_sprint_ativas) {
        this.permitir_multiplas_sprint_ativas = permitir_multiplas_sprint_ativas;
    }

    public Integer getHoras_trabalho_dia() {
        return horas_trabalho_dia;
    }

    public void setHoras_trabalho_dia(Integer horas_trabalho_dia) {
        this.horas_trabalho_dia = horas_trabalho_dia;
    }

    public Boolean getConsiderar_Feriados() {
        return considerar_Feriados;
    }

    public void setConsiderar_Feriados(Boolean considerar_Feriados) {
        this.considerar_Feriados = considerar_Feriados;
    }

    public Boolean getConsiderar_valorhoras() {
        return considerar_valorhoras;
    }

    public void setConsiderar_valorhoras(Boolean considerar_valorhoras) {
        this.considerar_valorhoras = considerar_valorhoras;
    }
}