package br.com.taskcontroller.Modelo;

import br.com.taskcontroller.Enums.TipoAlteracao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "epico_historico")
public class EpicoHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idhistorico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idepico", nullable = false)
    private Epico epico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private LocalDateTime dataAlteracao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TipoAlteracao tipo_alteracao;

    @Column(length = 500)
    private String valor_anterior;

    @Column(length = 500)
    private String valor_novo;

    @Column(length = 1000)
    private String descricao;

    @PrePersist
    public void prePersist() {
        if (dataAlteracao == null) {
            dataAlteracao = LocalDateTime.now();
        }
    }
}