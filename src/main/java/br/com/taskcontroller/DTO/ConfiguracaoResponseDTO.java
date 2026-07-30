package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Empreendimento;

public class ConfiguracaoResponseDTO {
    private Long idconfiguracao;
    private Empreendimento empreendimento;
    private Integer duracao_min_sprint;
    private Integer duracao_max_sprint;
    private Boolean permitir_sprint_sobreposta = false;
    private Boolean permitir_multiplas_sprint_ativas = false;
    private Integer horas_trabalho_dia = 8;
    private Boolean considerar_Feriados = true;
    private Boolean considerar_valorhoras = false;

    public Long getIdconfiguracao() {
        return idconfiguracao;
    }

    public void setIdconfiguracao(Long idconfiguracao) {
        this.idconfiguracao = idconfiguracao;
    }

    public Empreendimento getEmpreendimento() {
        return empreendimento;
    }

    public void setEmpreendimento(Empreendimento empreendimento) {
        this.empreendimento = empreendimento;
    }

    public Integer getDuracao_min_sprint() {
        return duracao_min_sprint;
    }

    public void setDuracao_min_sprint(Integer duracao_min_sprint) {
        this.duracao_min_sprint = duracao_min_sprint;
    }

    public Integer getDuracao_max_sprint() {
        return duracao_max_sprint;
    }

    public void setDuracao_max_sprint(Integer duracao_max_sprint) {
        this.duracao_max_sprint = duracao_max_sprint;
    }

    public Boolean getPermitir_sprint_sobreposta() {
        return permitir_sprint_sobreposta;
    }

    public void setPermitir_sprint_sobreposta(Boolean permitir_sprint_sobreposta) {
        this.permitir_sprint_sobreposta = permitir_sprint_sobreposta;
    }

    public Boolean getPermitir_multiplas_sprint_ativas() {
        return permitir_multiplas_sprint_ativas;
    }

    public void setPermitir_multiplas_sprint_ativas(Boolean permitir_multiplas_sprint_ativas) {
        this.permitir_multiplas_sprint_ativas = permitir_multiplas_sprint_ativas;
    }

    public Integer getHoras_trabalho_dia() {
        return horas_trabalho_dia;
    }

    public void setHoras_trabalho_dia(Integer horas_trabalho_dia) {
        this.horas_trabalho_dia = horas_trabalho_dia;
    }

    public Boolean getConsiderar_Feriados() {
        return considerar_Feriados;
    }

    public void setConsiderar_Feriados(Boolean considerar_Feriados) {
        this.considerar_Feriados = considerar_Feriados;
    }

    public Boolean getConsiderar_valorhoras() {
        return considerar_valorhoras;
    }

    public void setConsiderar_valorhoras(Boolean considerar_valorhoras) {
        this.considerar_valorhoras = considerar_valorhoras;
    }
}
