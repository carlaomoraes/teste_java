package br.com.taskcontroller.DTO;

import java.time.LocalDate;

public class SprintEstoriaRequestDTO {
    private Long idsprintEstoria;
    private Long idsprint;
    private Long idestoria;
    private int pontos;
    private Long horasestimadas;
    private LocalDate dataplanejamento;

    public Long getIdsprintEstoria() {
        return idsprintEstoria;
    }

    public void setIdsprintEstoria(Long idsprintEstoria) {
        this.idsprintEstoria = idsprintEstoria;
    }

    public Long getIdsprint() {
        return idsprint;
    }

    public void setIdsprint(Long idsprint) {
        this.idsprint = idsprint;
    }

    public Long getIdestoria() {
        return idestoria;
    }

    public void setIdestoria(Long idestoria) {
        this.idestoria = idestoria;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Long getHorasestimadas() {
        return horasestimadas;
    }

    public void setHorasestimadas(Long horasestimadas) {
        this.horasestimadas = horasestimadas;
    }

    public LocalDate getDataplanejamento() {
        return dataplanejamento;
    }

    public void setDataplanejamento(LocalDate dataplanejamento) {
        this.dataplanejamento = dataplanejamento;
    }
}
