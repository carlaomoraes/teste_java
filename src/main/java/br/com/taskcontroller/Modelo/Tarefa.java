package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtarefa;
    private String desctarefa;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idstatus")
    private StatusEntidades status;
    @ManyToOne
    @JoinColumn(name = "idestoria")
    private Estoria estoria;
    @ManyToOne
    @JoinColumn(name="idcriador")
    private Usuario criador;
    @ManyToOne
    @JoinColumn(name="idresponsavel")
    private Usuario responsavel;
    @Column(name = "horas_estimadas")
    private Long horas_estimadas;
    @Column(name = "horas_realizadas")
    private Long horas_realizadas;
    @Column(name = "bloqueada")
    private boolean bloqueada;
    @Column(name = "data_inicio")
    private LocalDate data_inicio;
    @Column(name = "data_fim_prevista")
    private LocalDate data_fim_prevista;
    @Column(name = "data_conclusao")
    private LocalDate data_conclusao;
    @ManyToOne
    @JoinColumn(name="idtipo_tarefa")
    private TipoTarefa tipotarefa;

    public Long getIdtarefa() {
        return idtarefa;
    }

    public void setIdtarefa(Long idtarefa) {
        this.idtarefa = idtarefa;
    }

    public String getDesctarefa() {
        return desctarefa;
    }

    public void setDesctarefa(String desctarefa) {
        this.desctarefa = desctarefa;
    }

    public StatusEntidades getStatus() {
        return status;
    }

    public void setStatus(StatusEntidades status) {
        this.status = status;
    }

    public Estoria getEstoria() {
        return estoria;
    }

    public void setEstoria(Estoria estoria) {
        this.estoria = estoria;
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

    public LocalDate getData_fim_prevista() {
        return data_fim_prevista;
    }

    public void setData_fim_prevista(LocalDate data_fim_prevista) {
        this.data_fim_prevista = data_fim_prevista;
    }

    public LocalDate getData_conclusao() {
        return data_conclusao;
    }

    public void setData_conclusao(LocalDate data_conclusao) {
        this.data_conclusao = data_conclusao;
    }

    public TipoTarefa getTipotarefa() {
        return tipotarefa;
    }

    public void setTipotarefa(TipoTarefa tipotarefa) {
        this.tipotarefa = tipotarefa;
    }
}
