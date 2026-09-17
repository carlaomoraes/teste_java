package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsprint;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idempreendimento", nullable = false)
    private Empreendimento empreendimento;
    private String descsprint;
    private LocalDate dtiniciosprint;
    private LocalDate dtfinalsprint;
    private boolean visivel;
    private LocalDate dtterminosprint;
    @ManyToOne
    @JoinColumn(name = "idstatus")
    private StatusEntidades status;

    public Long getIdsprint() {
        return idsprint;
    }

    public void setIdsprint(Long idsprint) {
        this.idsprint = idsprint;
    }

    public Empreendimento getEmpreendimento() {
        return empreendimento;
    }

    public void setEmpreendimento(Empreendimento empreendimento) {
        this.empreendimento = empreendimento;
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

    public LocalDate getDtterminosprint() {
        return dtterminosprint;
    }

    public void setDtterminosprint(LocalDate dtterminosprint) {
        this.dtterminosprint = dtterminosprint;
    }

    public StatusEntidades getStatus() {
        return status;
    }

    public void setStatus(StatusEntidades status) {
        this.status = status;
    }
}
