package br.com.taskcontroller.Modelo;

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
