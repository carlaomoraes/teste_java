package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.Prioridades;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.Usuario;

import java.time.LocalDate;

public class EpicoRequestDTO {
    private Long idepico;
    private Long idempreendimento;
    private Long idresponsavel;
    private Long idstatus;
    private Long idprioridade;
    private int bloqueado;
    private LocalDate data_inicio;
    private LocalDate data_fim_prevista;
    private LocalDate data_cadastro;
    private String codepico;
    private String nome;
    private String cor = "#2196F3";
    private Double percentual = 0.0;
    private int ativo;

    public Long getIdepico() {
        return idepico;
    }

    public void setIdepico(Long idepico) {
        this.idepico = idepico;
    }

    public Long getIdempreendimento() {
        return idempreendimento;
    }

    public void setIdempreendimento(Long idempreendimento) {
        this.idempreendimento = idempreendimento;
    }

    public Long getIdresponsavel() {
        return idresponsavel;
    }

    public void setIdresponsavel(Long idresponsavel) {
        this.idresponsavel = idresponsavel;
    }

    public Long getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Long idstatus) {
        this.idstatus = idstatus;
    }

    public Long getIdprioridade() {
        return idprioridade;
    }

    public void setIdprioridade(Long idprioridade) {
        this.idprioridade = idprioridade;
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

    public Double getPercentual() {
        return percentual;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
}