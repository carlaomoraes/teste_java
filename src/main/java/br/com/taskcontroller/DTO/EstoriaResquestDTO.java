package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Empreendimento_Equipe;
import br.com.taskcontroller.Modelo.Epico;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.Usuario;

import java.sql.Blob;
import java.time.LocalDate;

public class EstoriaResquestDTO {
    private Long idestoria;
    private String descestoria;
    private Usuario Criador;
    private Usuario Responsavel;
    private Epico epico;
    private boolean bloqueada;
    private StatusEntidades status;
    private String resumo;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private Long pontos;
    private boolean ativa;
    private String tags;
    private String criterios;
    private Empreendimento_Equipe empreendimentoEquipe;

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

    public Usuario getCriador() {
        return Criador;
    }

    public void setCriador(Usuario criador) {
        Criador = criador;
    }

    public Usuario getResponsavel() {
        return Responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        Responsavel = responsavel;
    }

    public Epico getEpico() {
        return epico;
    }

    public void setEpico(Epico epico) {
        this.epico = epico;
    }

    public boolean getBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public StatusEntidades getStatus() {
        return status;
    }

    public void setStatus(StatusEntidades status) {
        this.status = status;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
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

    public Long getPontos() {
        return pontos;
    }

    public void setPontos(Long pontos) {
        this.pontos = pontos;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Empreendimento_Equipe getEmpreendimentoEquipe() {
        return empreendimentoEquipe;
    }

    public void setEmpreendimentoEquipe(Empreendimento_Equipe empreendimentoEquipe) {
        this.empreendimentoEquipe = empreendimentoEquipe;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public boolean isAtiva() {
        return ativa;
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
