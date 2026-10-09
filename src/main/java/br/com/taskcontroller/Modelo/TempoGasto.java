package br.com.taskcontroller.Modelo;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tempo_gasto")
public class TempoGasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtempo_gasto;

    // Relacionamento com a classe Tarefa (Chave Estrangeira)
    @ManyToOne
    @JoinColumn(name = "idtarefa")
    private Tarefa tarefa;

    // Relacionamento com a classe Usuario (Chave Estrangeira)
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @Column(name = "data_execucao") // Mapeia para o nome físico do banco caso esteja com o erro de digitação
    private LocalDate data_execucao;

    @Column(name = "hora_execucao")
    private LocalTime hora_execucao;

    private String resumo;

    public Long getIdtempo_gasto() {
        return idtempo_gasto;
    }

    public void setIdtempo_gasto(Long idtempo_gasto) {
        this.idtempo_gasto = idtempo_gasto;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData_execucao() {
        return data_execucao;
    }

    public void setData_execucao(LocalDate data_execucao) {
        this.data_execucao = data_execucao;
    }

    public LocalTime getHora_execucao() {
        return hora_execucao;
    }

    public void setHora_execucao(LocalTime hora_execucao) {
        this.hora_execucao = hora_execucao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
}