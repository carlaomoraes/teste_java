package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Tarefa;
import br.com.taskcontroller.Modelo.Usuario;

import java.sql.Timestamp;
import java.time.LocalDate;

public class TempoGastoRequestDTO {
    private Long idtempo_gasto;
    private Tarefa tarefa;
    private Usuario usuario;
    private LocalDate data_execucao;
    private LocalDate hora_execucaoo;
    private Long duracao; // Geralmente guardado em minutos ou horas inteiras

    public Long getIdtempo_gasto() {
        return idtempo_gasto;
    }

    public void setIdtempo_gasto(Long idtempo_gasto) {
        this.idtempo_gasto = idtempo_gasto;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData_execucao() {
        return data_execucao;
    }

    public void setData_execucao(LocalDate data_execucao) {
        this.data_execucao = data_execucao;
    }

    public LocalDate getHora_execucaoo() {
        return hora_execucaoo;
    }

    public void setHora_execucaoo(LocalDate hora_execucaoo) {
        this.hora_execucaoo = hora_execucaoo;
    }

    public Long getDuracao() {
        return duracao;
    }

    public void setDuracao(Long duracao) {
        this.duracao = duracao;
    }
}
