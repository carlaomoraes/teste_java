package br.com.taskcontroller.DTO;

public class StatusTransicaoResponseDTO {
    private Long idtransicao;
    private Long statusOrigem;
    private Long statusDestino;

    public Long getIdtransicao() {
        return idtransicao;
    }

    public void setIdtransicao(Long idtransicao) {
        this.idtransicao = idtransicao;
    }

    public Long getStatusOrigem() {
        return statusOrigem;
    }

    public void setStatusOrigem(Long statusOrigem) {
        this.statusOrigem = statusOrigem;
    }

    public Long getStatusDestino() {
        return statusDestino;
    }

    public void setStatusDestino(Long statusDestino) {
        this.statusDestino = statusDestino;
    }
}
