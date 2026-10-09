package br.com.taskcontroller.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class TempoGastoResponseDTO {
    private Long idtempo_gasto;
    private Long idusuario;
    private Long idTarefa;
    private LocalDate data_execucao;
    private LocalTime hora_execucaoo;
    private String resumo;

    public Long getIdtempo_gasto() {
        return idtempo_gasto;
    }

    public void setIdtempo_gasto(Long idtempo_gasto) {
        this.idtempo_gasto = idtempo_gasto;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }

    public LocalDate getData_execucao() {
        return data_execucao;
    }

    public void setData_execucao(LocalDate data_execucao) {
        this.data_execucao = data_execucao;
    }

    public LocalTime getHora_execucaoo() {
        return hora_execucaoo;
    }

    public void setHora_execucaoo(LocalTime hora_execucaoo) {
        this.hora_execucaoo = hora_execucaoo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
}
