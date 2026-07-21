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
    @JoinColumn(name="criador")
    private Usuario criador;
    @ManyToOne
    @JoinColumn(name="responsavel")
    private Usuario responsavel;
    @Column(name = "horas_estimadas")
    private Long horas_estimadas;
    @Column(name = "horas_realizadas")
    private Long horas_realizadas;
    @Column(name = "bloqueada")
    private boolean bloqueada;
    private LocalDate data_inicio;
    private LocalDate data_fim_prevista;
    private LocalDate data_conlusao;
    private int ativa;
    @ManyToOne
    @JoinColumn(name="idtipo_tarefa")
    private TipoTarefa tipoTarefa;

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

    public LocalDate getData_conlusao() {
        return data_conlusao;
    }

    public void setData_conlusao(LocalDate data_conlusao) {
        this.data_conlusao = data_conlusao;
    }

    public int getAtiva() {
        return ativa;
    }

    public void setAtiva(int ativa) {
        this.ativa = ativa;
    }

    public TipoTarefa getTipoTarefa() {
        return tipoTarefa;
    }

    public void setTipoTarefa(TipoTarefa tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }
}
