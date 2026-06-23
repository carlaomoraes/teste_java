package br.com.taskboard.demo.Modelo;

import br.com.taskboard.demo.Enuns.Prioridade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Epico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idepico")
    private Long idepico;
    @Column(name = "descepico")
    private String descepico;
    @Column(name = "obsepico")
    private String obsepico;
    @Column(name = "bloqueado")
    private int bloqueado;
    @Column(name = "status", length = 20)
    private Prioridade status;
    @ManyToOne
    @JoinColumn(name = "responsavel")
    private Usuario responsavel;
    @Column(name="data_inicio")
    private LocalDate data_inicio;
    @Column(name="data_fim_prevista")
    private LocalDate data_fim_prevista;





}
