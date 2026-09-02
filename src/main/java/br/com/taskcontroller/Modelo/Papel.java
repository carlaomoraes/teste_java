package br.com.taskcontroller.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Papel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpapel;
    private String descpapel;
    private BigDecimal valorhora;
    private boolean ativo;
    private int tipopapel;

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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getTipopapel() {
        return tipopapel;
    }

    public void setTipopapel(int tipopapel) {
        this.tipopapel = tipopapel;
    }
}
