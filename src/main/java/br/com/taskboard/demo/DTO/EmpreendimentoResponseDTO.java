package br.com.taskboard.demo.DTO;

import br.com.taskboard.demo.Modelo.Empreendimento;

import java.time.LocalDate;

public class EmpreendimentoResponseDTO {
    private Long ideempreendimento;
    private String descempreendimento;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private String siglaempreendimento;

    public Long getIdeempreendimento() {
        return ideempreendimento;
    }

    public void setIdeempreendimento(Long ideempreendimento) {
        this.ideempreendimento = ideempreendimento;
    }

    public String getDescempreendimento() {
        return descempreendimento;
    }

    public void setDescempreendimento(String descempreendimento) {
        this.descempreendimento = descempreendimento;
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

    public String getSiglaempreendimento() {
        return siglaempreendimento;
    }

    public void setSiglaempreendimento(String siglaempreendimento) {
        this.siglaempreendimento = siglaempreendimento;
    }

}
