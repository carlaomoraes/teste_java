package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.Prioridades;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EpicoResponseDTO {
    private Long idepico;
    private Empreendimento empreendimento;
    private Usuario responsavel;
    private StatusEntidades status;
    private Prioridades prioridade;
    private int bloqueado = 0;
    private LocalDate data_inicio;
    private LocalDate data_fim_prevista;
    private LocalDate data_cadastro;
    private String codepico;
    private String nome;
    private String cor = "#2196F3";
    private Long percentual;
    private int ativo;

    public Long getIdepico() {
        return idepico;
    }

    public void setIdepico(Long idepico) {
        this.idepico = idepico;
    }

    public Empreendimento getEmpreendimento() {
        return empreendimento;
    }

    public void setEmpreendimento(Empreendimento empreendimento) {
        this.empreendimento = empreendimento;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public StatusEntidades getStatus() {
        return status;
    }

    public void setStatus(StatusEntidades status) {
        this.status = status;
    }

    public Prioridades getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridades prioridade) {
        this.prioridade = prioridade;
    }

    public int getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(int bloqueado) {
        this.bloqueado = bloqueado;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_fim_prevista() {
        return data_fim_prevista;
    }

    public void setData_fim_prevista(LocalDate data_fim_prevista) {
        this.data_fim_prevista = data_fim_prevista;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getCodepico() {
        return codepico;
    }

    public void setCodepico(String codepico) {
        this.codepico = codepico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Long getPercentual() {
        return percentual;
    }

    public void setPercentual(Long percentual) {
        this.percentual = percentual;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
}