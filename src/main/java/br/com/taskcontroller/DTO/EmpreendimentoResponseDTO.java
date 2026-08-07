package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Prioridades;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.Usuario;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class EmpreendimentoResponseDTO {
    private Long idempreendimento;
    private String descempreendimento;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private LocalDate data_cadastro;
    @ManyToOne
    @JoinColumn(name = "idstatus")
    private StatusEntidades status;
    private String siglaempreendimento;
    @ManyToOne
    @JoinColumn(name = "idgestor")
    private Usuario idgestor;
    private String cor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprioridade")
    private Prioridades prioridade;
    private Long percentual;
    private boolean bloqueado;
    private String codempreendimento;
    private int ativo;

    private Integer duracao_max_sprint;

    private int permitir_sprint_sobreposta = 0;

    private int permitir_multiplas_sprint_ativas = 0;

    private int horas_trabalho_dia = 8;

    private int considerar_Feriados = 1;

    private int considerar_valorhoras = 1;

    public Long getIdempreendimento() {
        return idempreendimento;
    }

    public void setIdempreendimento(Long idempreendimento) {
        this.idempreendimento = idempreendimento;
    }

    public String getDescempreendimento() {
        return descempreendimento;
    }

    public void setDescempreendimento(String descempreendimento) {
        this.descempreendimento = descempreendimento;
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

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public StatusEntidades getStatus() {
        return status;
    }

    public void setStatus(StatusEntidades status) {
        this.status = status;
    }

    public String getSiglaempreendimento() {
        return siglaempreendimento;
    }

    public void setSiglaempreendimento(String siglaempreendimento) {
        this.siglaempreendimento = siglaempreendimento;
    }

    public Usuario getIdgestor() {
        return idgestor;
    }

    public void setIdgestor(Usuario idgestor) {
        this.idgestor = idgestor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Prioridades getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridades prioridade) {
        this.prioridade = prioridade;
    }

    public Long getPercentual() {
        return percentual;
    }

    public void setPercentual(Long percentual) {
        this.percentual = percentual;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getCodempreendimento() {
        return codempreendimento;
    }

    public void setCodempreendimento(String codempreendimento) {
        this.codempreendimento = codempreendimento;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public Integer getDuracao_max_sprint() {
        return duracao_max_sprint;
    }

    public void setDuracao_max_sprint(Integer duracao_max_sprint) {
        this.duracao_max_sprint = duracao_max_sprint;
    }

    public int getPermitir_sprint_sobreposta() {
        return permitir_sprint_sobreposta;
    }

    public void setPermitir_sprint_sobreposta(int permitir_sprint_sobreposta) {
        this.permitir_sprint_sobreposta = permitir_sprint_sobreposta;
    }

    public int getPermitir_multiplas_sprint_ativas() {
        return permitir_multiplas_sprint_ativas;
    }

    public void setPermitir_multiplas_sprint_ativas(int permitir_multiplas_sprint_ativas) {
        this.permitir_multiplas_sprint_ativas = permitir_multiplas_sprint_ativas;
    }

    public int getHoras_trabalho_dia() {
        return horas_trabalho_dia;
    }

    public void setHoras_trabalho_dia(int horas_trabalho_dia) {
        this.horas_trabalho_dia = horas_trabalho_dia;
    }

    public int getConsiderar_Feriados() {
        return considerar_Feriados;
    }

    public void setConsiderar_Feriados(int considerar_Feriados) {
        this.considerar_Feriados = considerar_Feriados;
    }

    public int getConsiderar_valorhoras() {
        return considerar_valorhoras;
    }

    public void setConsiderar_valorhoras(int considerar_valorhoras) {
        this.considerar_valorhoras = considerar_valorhoras;
    }
}