package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Modelo.Sprint;

import java.time.LocalDate;

public class SprintEstoriaResponseDTO {
    private Long idsprintEstoria;
    private Sprint sprint;
    private Estoria estoria;
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

    public LocalDate getDataplanejamento() {
        return dataplanejamento;
    }

    public void setDataplanejamento(LocalDate dataplanejamento) {
        this.dataplanejamento = dataplanejamento;
    }
}
