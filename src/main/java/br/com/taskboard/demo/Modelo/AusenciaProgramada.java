package br.com.taskboard.demo.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "ausencia_programada")
public class AusenciaProgramada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ausencia;

    private LocalDate data_inicio;
    private LocalDate data_fim;
    @ManyToOne
    @JoinColumn(name = "id_tipo_ausencia")
    private TipoAusencia tipo_ausencia;

    private String observacao;

    private String status;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
