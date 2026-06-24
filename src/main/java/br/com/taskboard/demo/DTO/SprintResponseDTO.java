package br.com.taskboard.demo.DTO;

import java.time.LocalDate;

public class SprintResponseDTO {
    private Long idsprint;
    private String descsprint;
    private LocalDate dtiniciosprint;
    private LocalDate dtfinalsprint;
    private boolean visivel;
    private boolean ativa;
    private LocalDate dtterminosprint;

    public Long getIdsprint() {
        return idsprint;
    }

    public void setIdsprint(Long idsprint) {
        this.idsprint = idsprint;
    }

    public String getDescsprint() {
        return descsprint;
    }

    public void setDescsprint(String descsprint) {
        this.descsprint = descsprint;
    }

    public LocalDate getDtiniciosprint() {
        return dtiniciosprint;
    }

    public void setDtiniciosprint(LocalDate dtiniciosprint) {
        this.dtiniciosprint = dtiniciosprint;
    }

    public LocalDate getDtfinalsprint() {
        return dtfinalsprint;
    }

    public void setDtfinalsprint(LocalDate dtfinalsprint) {
        this.dtfinalsprint = dtfinalsprint;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public LocalDate getDtterminosprint() {
        return dtterminosprint;
    }

    public void setDtterminosprint(LocalDate dtterminosprint) {
        this.dtterminosprint = dtterminosprint;
    }
}
