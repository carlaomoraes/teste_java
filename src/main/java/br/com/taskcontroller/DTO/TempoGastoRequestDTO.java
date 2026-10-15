package br.com.taskcontroller.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class TempoGastoRequestDTO {
    private Long idtempo_gasto;
    private Long idtarefa;
    private Long idusuario;
    private LocalDate data_execucao;
    private LocalTime hora_execucao;
    private String resumo;


    public Long getIdtempo_gasto() {
        return idtempo_gasto;
    }

    public void setIdtempo_gasto(Long idtempo_gasto) {
        this.idtempo_gasto = idtempo_gasto;
    }

    public Long getIdtarefa() {
        return idtarefa;
    }

    public void setIdtarefa(Long idtarefa) {
        this.idtarefa = idtarefa;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public LocalDate getData_execucao() {
        return data_execucao;
    }

    public void setData_execucao(LocalDate data_execucao) {
        this.data_execucao = data_execucao;
    }

    public LocalTime getHora_execucao() {
        return hora_execucao;
    }

    public void setHora_execucao(LocalTime hora_execucao) {
        this.hora_execucao = hora_execucao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    @Override
    public String toString() {
        return "TempoGastoRequestDTO{" +
                "idtempo_gasto=" + idtempo_gasto +
                ", idtarefa=" + idtarefa +
                ", idusuario=" + idusuario +
                ", data_execucao=" + data_execucao +
                ", hora_execucao=" + hora_execucao +
                ", resumo='" + resumo + '\'' +
                '}';
    }
}
