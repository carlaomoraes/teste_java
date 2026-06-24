package br.com.taskboard.demo.DTO;

import br.com.taskboard.demo.Enuns.Prioridade;
import br.com.taskboard.demo.Modelo.Epico;
import br.com.taskboard.demo.Modelo.Usuario;

public class EstoriaResquestDTO {
    private Long idestoria;
    private String descestoria;
    private Usuario idcriador;
    private Usuario idresponsavel;
    private Epico idepico;
    private Boolean bloqueada;
    private Prioridade status;

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

    public Prioridade getStatus() {
        return status;
    }

    public void setStatus(Prioridade status) {
        this.status = status;
    }
}
