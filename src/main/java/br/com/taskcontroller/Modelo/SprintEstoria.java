package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "sprint_estoria")
@Getter
@Setter
@NoArgsConstructor
public class SprintEstoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSprintEstoria")
    private Long idsprintEstoria;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsprint", nullable = false)
    private Sprint sprint;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idestoria", nullable = false)
    private Estoria estoria;
    @Column(name = "ordem")
    private int ordem = 0;
    @Column(name = "dataplanejamento")
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
