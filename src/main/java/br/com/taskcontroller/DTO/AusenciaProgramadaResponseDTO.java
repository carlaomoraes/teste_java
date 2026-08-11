package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Tipo_Ausencia;
import br.com.taskcontroller.Modelo.Usuario;

import java.time.LocalDate;

public class AusenciaProgramadaResponseDTO {
    private Long idausencia;
    private Long idusuario;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private String observacao;
    private String status;
    private LocalDate data_cadastro;
    private Tipo_Ausencia tipo_ausencia;

    public Long getIdausencia() {
        return idausencia;
    }

    public void setIdausencia(Long idausencia) {
        this.idausencia = idausencia;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Tipo_Ausencia getTipo_ausencia() {
        return tipo_ausencia;
    }

    public void setTipo_ausencia(Tipo_Ausencia tipo_ausencia) {
        this.tipo_ausencia = tipo_ausencia;
    }
}
