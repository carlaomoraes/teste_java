package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Modelo.Sprint;

import java.time.LocalDate;

public class SprintEstoriaRequestDTO {
    private Long idsprintEstoria;
    private Sprint sprint;
    private Estoria estoria;
    private int ordem = 0;
    private LocalDate dataplanejamento;

    public Long getIdsprintEstoria() {
        return idsprintEstoria;
    }

    public void setIdsprintEstoria(Long idsprintEstoria) {
        this.idsprintEstoria = idsprintEstoria;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public Estoria getEstoria() {
        return estoria;
    }

    public void setEstoria(Estoria estoria) {
        this.estoria = estoria;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public LocalDate getDataplanejamento() {
        return dataplanejamento;
    }

    public void setDataplanejamento(LocalDate dataplanejamento) {
        this.dataplanejamento = dataplanejamento;
    }
}
