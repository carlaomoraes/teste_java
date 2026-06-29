package br.com.taskboard.demo.DTO;

import br.com.taskboard.demo.Modelo.StatusEntidades;
import br.com.taskboard.demo.Modelo.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class EmpreendimentoRequestDTO {
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

    public void setCor(String Cor) {
        this.cor = cor;
    }
}