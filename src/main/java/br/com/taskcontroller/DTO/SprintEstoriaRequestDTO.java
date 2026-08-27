package br.com.taskcontroller.DTO;

import java.time.LocalDate;

public class SprintEstoriaRequestDTO {
    private Long idsprintEstoria;
    private Long idsprint;
    private Long idestoria;
    private Long idresponsavel;
    private Long idprioridade;
    private Long idepico;
    private int pontos;
    private Long horasestimadas;
    private LocalDate dataplanejamento;
    private int ordem;

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

    public Long getIdresponsavel() {
        return idresponsavel;
    }

    public void setIdresponsavel(Long idresponsavel) {
        this.idresponsavel = idresponsavel;
    }

    public Long getIdprioridade() {
        return idprioridade;
    }

    public void setIdprioridade(Long idprioridade) {
        this.idprioridade = idprioridade;
    }

    public Long getIdepico() {
        return idepico;
    }

    public void setIdepico(Long idepico) {
        this.idepico = idepico;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
}
