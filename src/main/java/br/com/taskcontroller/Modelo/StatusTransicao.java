package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;

@Entity
public class StatusTransicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtransicao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idstatus_origem")
    private StatusEntidades statusOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idstatus_destino")
    private StatusEntidades statusDestino;

    public Long getIdtransicao() {
        return idtransicao;
    }

    public void setIdtransicao(Long idtransicao) {
        this.idtransicao = idtransicao;
    }

    public StatusEntidades getStatusOrigem() {
        return statusOrigem;
    }

    public void setStatusOrigem(StatusEntidades statusOrigem) {
        this.statusOrigem = statusOrigem;
    }

    public StatusEntidades getStatusDestino() {
        return statusDestino;
    }

    public void setStatusDestino(StatusEntidades statusDestino) {
        this.statusDestino = statusDestino;
    }
}