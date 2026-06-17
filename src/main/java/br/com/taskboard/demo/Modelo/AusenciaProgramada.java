package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "ausencia_programada")
public class AusenciaProgramada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idausencia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario")
    private Usuario idusuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_ausencia")
    private TipoAusencia tipoausencia;
    @Column(name = "data_inicio") // Mapeia para o nome físico do banco caso esteja com o erro de digitação
    private Timestamp dataInicio;
    @Column(name = "data_fim") // Mapeia para o nome físico do banco caso esteja com o erro de digitação
    private Timestamp dataFim;
    @Column(name="observacao")
    private String observacao;
    @Column(name="status")
    private String status;
    @Column(name = "data_cadastro") // Mapeia para o nome físico do banco caso esteja com o erro de digitação
    private Timestamp dataCadastro;
}
