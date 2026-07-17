package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Empreendimento_Equipe;
import br.com.taskcontroller.Modelo.Epico;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.Usuario;

import java.sql.Blob;
import java.time.LocalDate;

public class EstoriaResquestDTO {
    private Long idestoria;
    private String descestoria;
    private Usuario idcriador;
    private Usuario idresponsavel;
    private Epico idepico;
    private Boolean bloqueada;
    private StatusEntidades status;
    private Blob resumo;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private Long pontos;
    private Long horas_estimadas;
    private Long horas_realizadas;
    private int ativa;
    private Empreendimento_Equipe empreendimento_Equipe;

    public Long getIdestoria() {
        return idestoria;
    }

    public void setIdestoria(Long idestoria) {
        this.idestoria = idestoria;
    }

    public String getDescestoria() {
        return descestoria;
    }

    public void setDescestoria(String descestoria) {
        this.descestoria = descestoria;
    }

    public Usuario getIdcriador() {
        return idcriador;
    }

    public void setIdcriador(Usuario idcriador) {
        this.idcriador = idcriador;
    }

    public Usuario getIdresponsavel() {
        return idresponsavel;
    }

    public void setIdresponsavel(Usuario idresponsavel) {
        this.idresponsavel = idresponsavel;
    }

    public Epico getIdepico() {
        return idepico;
    }

    public void setIdepico(Epico idepico) {
        this.idepico = idepico;
    }

    public Boolean getBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(Boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public StatusEntidades getStatus() {
        return status;
    }

    public void setStatus(StatusEntidades status) {
        this.status = status;
    }

    public Blob getResumo() {
        return resumo;
    }

    public void setResumo(Blob resumo) {
        this.resumo = resumo;
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

    public Long getPontos() {
        return pontos;
    }

    public void setPontos(Long pontos) {
        this.pontos = pontos;
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

    public int getAtiva() {
        return ativa;
    }

    public void setAtiva(int ativa) {
        this.ativa = ativa;
    }

    public Empreendimento_Equipe getEmpreendimento_Equipe() {
        return empreendimento_Equipe;
    }

    public void setEmpreendimento_Equipe(Empreendimento_Equipe empreendimento_Equipe) {
        this.empreendimento_Equipe = empreendimento_Equipe;
    }
}
