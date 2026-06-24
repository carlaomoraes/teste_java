package br.com.taskboard.demo.DTO;

public class EpicoResponseDTO {
    private Long idepico;
    private String descepico;
    private String obsepico;
    private int bloqueado;

    public Long getIdepico() {
        return idepico;
    }

    public void setIdepico(Long idepico) {
        this.idepico = idepico;
    }

    public String getDescepico() {
        return descepico;
    }

    public void setDescepico(String descepico) {
        this.descepico = descepico;
    }

    public String getObsepico() {
        return obsepico;
    }

    public void setObsepico(String obsepico) {
        this.obsepico = obsepico;
    }

    public int getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(int bloqueado) {
        this.bloqueado = bloqueado;
    }
}