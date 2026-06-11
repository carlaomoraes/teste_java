package br.com.taskboard.demo.Modelo;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tempo_gasto")
public class Tempo_gasto {
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

    @Column(name = "data_excucao") // Mapeia para o nome físico do banco caso esteja com o erro de digitação
    private Timestamp dataExecucao;

    @Column(name = "hora_excucao")
    private Timestamp horaExecucao;

    private Long duracao; // Geralmente guardado em minutos ou horas inteiras
}