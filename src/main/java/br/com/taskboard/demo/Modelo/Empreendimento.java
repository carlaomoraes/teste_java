package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "empreendimento")
public class Empreendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idempreendimento;
    private String descempreendimento;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private LocalDate data_cadastro;
    @PrePersist
    public void prePersist() {
        data_cadastro = LocalDate.now();
    }
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
}
