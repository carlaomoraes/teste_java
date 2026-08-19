package br.com.taskcontroller.Record.Estoria;

import java.sql.Blob;
import java.time.LocalDate;

public class EstoriaInclusaoDTO {
    Long idestoria;
    Long idepico;
    String descestoria;
    Long idcriador;
    Long idresponsavel;
    Long idstatus;
    boolean bloqueada;
    Blob resumo;
    LocalDate data_inicio;
    LocalDate data_fim;
    int pontos;
    Long horas_estimadas;
    Long horas_realizadas;
    boolean ativa;
    Long idempreendiemnto_equipe;
    private String tags;
    private String criterios;

    public Long getIdestoria() {
        return idestoria;
    }

    public void setIdestoria(Long idestoria) {
        this.idestoria = idestoria;
    }

    public Long getIdepico() {
        return idepico;
    }

    public void setIdepico(Long idepico) {
        this.idepico = idepico;
    }

    public String getDescestoria() {
        return descestoria;
    }

    public void setDescestoria(String descestoria) {
        this.descestoria = descestoria;
    }

    public Long getIdcriador() {
        return idcriador;
    }

    public void setIdcriador(Long idcriador) {
        this.idcriador = idcriador;
    }

    public Long getIdresponsavel() {
        return idresponsavel;
    }

    public void setIdresponsavel(Long idresponsavel) {
        this.idresponsavel = idresponsavel;
    }

    public Long getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Long idstatus) {
        this.idstatus = idstatus;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
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

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
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

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Long getIdempreendiemnto_equipe() {
        return idempreendiemnto_equipe;
    }

    public void setIdempreendiemnto_equipe(Long idempreendiemnto_equipe) {
        this.idempreendiemnto_equipe = idempreendiemnto_equipe;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCriterios() {
        return criterios;
    }

    public void setCriterios(String criterios) {
        this.criterios = criterios;
    }
}