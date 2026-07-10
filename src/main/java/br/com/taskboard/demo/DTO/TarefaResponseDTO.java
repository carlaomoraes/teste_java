package br.com.taskboard.demo.DTO;

import br.com.taskboard.demo.Modelo.Estoria;
import br.com.taskboard.demo.Modelo.TipoTarefa;
import br.com.taskboard.demo.Modelo.Usuario;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class TarefaResponseDTO {
    private Long idtarefa;
    private String desctarefa;
    private String status;
    private Estoria estoria;
    private Usuario criador;
    private Usuario responsavel;
    private Long horas_estimadas;
    private Long horas_gastas;
    private boolean bloqueada;
    private LocalDate data_inicio;
    private LocalDate data_fim_prevista;
    private LocalDate data_conlusao;
    private int ativa;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public Long getHoras_gastas() {
        return horas_gastas;
    }

    public void setHoras_gastas(Long horas_gastas) {
        this.horas_gastas = horas_gastas;
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
