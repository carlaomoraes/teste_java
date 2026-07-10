package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "epico")
@Getter
@Setter
@NoArgsConstructor
public class Epico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idepico")
    private Long idepico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idempreendimento", nullable = false)
    private Empreendimento empreendimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idresponsavel")
    private Usuario responsavel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idstatus")
    private StatusEntidades status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprioridade")
    private Prioridades prioridade;

    @Column(name = "bloqueado")
    private Boolean bloqueado = false;

    @Column(name = "data_inicio")
    private LocalDate data_inicio;

    @Column(name = "data_fim_prevista")
    private LocalDate data_fim_prevista;

    @Column(name = "data_cadastro")
    private LocalDate data_cadastro;

    @PrePersist
    public void prePersist() {
        data_cadastro = LocalDate.now();
    }

    @Column(length = 20)
    private String codepico;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 7)
    private String cor = "#2196F3";

    @Column
    private Double percentual = 0.0;

    @Column(length = 10, nullable = false)
    private int ativo;
}