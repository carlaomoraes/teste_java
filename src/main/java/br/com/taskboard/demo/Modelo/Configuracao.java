package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity
@Table(name = "configuracao")
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idconfiguracao")
    private Long idconfiguracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idempreendimento", nullable = false)
    private Empreendimento empreendimento;

    @Column(name = "duracao_min_sprint", nullable = false)
    private Integer duracao_min_sprint;

    @Column(name = "duracao_max_sprint", nullable = false)
    private Integer duracao_max_sprint;

    @Column(name = "permitir_sprint_sobreposta", nullable = false)
    private Boolean permitir_sprint_sobreposta = false;

    @Column(name = "permitir_multiplas_sprint_ativas", nullable = false)
    private Boolean permitir_multiplas_sprint_ativas = false;

    @Column(name = "horas_trabalho_dia", nullable = false)
    private Integer horas_trabalho_dia = 8;

    @Column(name = "considerar_Feriados", nullable = false)
    private Boolean considerar_Feriados = true;

}