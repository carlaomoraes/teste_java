package br.com.taskcontroller.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TipoEntidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtipo_entidade;
    private String desctipo_entidade;
    private boolean ativo;

    public Long getIdtipo_entidade() {
        return idtipo_entidade;
    }

    public void setIdtipo_entidade(Long idtipo_entidade) {
        this.idtipo_entidade = idtipo_entidade;
    }

    public String getDesctipo_entidade() {
        return desctipo_entidade;
    }

    public void setDesctipo_entidade(String desctipo_entidade) {
        this.desctipo_entidade = desctipo_entidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
