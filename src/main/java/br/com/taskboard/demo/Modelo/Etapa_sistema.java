package br.com.taskboard.demo.Modelo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Etapa_sistema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idetapa_sistema")
    private Long idetapa_sistema;
    @Column(name = "descestapa_sistema")
    private String descetapa_sistema;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsistema")
    private Sistema sistema;
    @Column(name = "backlog")
    private int backlog;
}
