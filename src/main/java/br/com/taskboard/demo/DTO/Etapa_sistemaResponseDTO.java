package br.com.taskboard.demo.DTO;


import br.com.taskboard.demo.Modelo.Sistema;

public class Etapa_sistemaResponseDTO {
    private Long idetapa_sistema;
    private String descetapa_sistema;
    private Sistema sistema;
    private int backlog;

    public Long getIdetapa_sistema() {
        return idetapa_sistema;
    }

    public void setIdetapa_sistema(Long idetapa_sistema) {
        this.idetapa_sistema = idetapa_sistema;
    }

    public String getDescetapa_sistema() {
        return descetapa_sistema;
    }

    public void setDescetapa_sistema(String descetapa_sistema) {
        this.descetapa_sistema = descetapa_sistema;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public int getBacklog() {
        return backlog;
    }

    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }
}
