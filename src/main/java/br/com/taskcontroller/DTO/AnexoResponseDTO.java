package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Epico;
import br.com.taskcontroller.Modelo.Usuario;

import java.time.LocalDate;

public class AnexoResponseDTO {
    private Long idanexo;

    private Usuario usuario;

    private String nomearquivo;

    private String nomeoriginal;

    private String descricao;

    private String categoria;

    private String tipoarquivo;

    private int tamanho;

    private String caminho;

    private LocalDate dataupload;

    private Epico epico;

    public Long getIdanexo() {
        return idanexo;
    }

    public void setIdanexo(Long idanexo) {
        this.idanexo = idanexo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    public String getNomeoriginal() {
        return nomeoriginal;
    }

    public void setNomeoriginal(String nomeoriginal) {
        this.nomeoriginal = nomeoriginal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoarquivo() {
        return tipoarquivo;
    }

    public void setTipoarquivo(String tipoarquivo) {
        this.tipoarquivo = tipoarquivo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public LocalDate getDataupload() {
        return dataupload;
    }

    public void setDataupload(LocalDate dataupload) {
        this.dataupload = dataupload;
    }

    public Epico getEpico() {
        return epico;
    }

    public void setEpico(Epico epico) {
        this.epico = epico;
    }
}
