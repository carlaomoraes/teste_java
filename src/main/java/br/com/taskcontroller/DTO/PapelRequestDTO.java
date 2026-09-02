package br.com.taskcontroller.DTO;

import java.math.BigDecimal;

public class PapelRequestDTO {
    private Long idpapel;
    private String descpapel;
    private BigDecimal valorhora;
    int tipopapel;
    boolean ativo;

    public Long getIdpapel() {
        return idpapel;
    }

    public void setIdpapel(Long idpapel) {
        this.idpapel = idpapel;
    }

    public String getDescpapel() {
        return descpapel;
    }

    public void setDescpapel(String descpapel) {
        this.descpapel = descpapel;
    }

    public BigDecimal getValorhora() {
        return valorhora;
    }

    public void setValorhora(BigDecimal valorhora) {
        this.valorhora = valorhora;
    }

    public int getTipopapel() {
        return tipopapel;
    }

    public void setTipopapel(int tipopapel) {
        this.tipopapel = tipopapel;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
