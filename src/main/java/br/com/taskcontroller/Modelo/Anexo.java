package br.com.taskcontroller.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "anexo")
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idanexo")
    private Long idanexo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idepico", nullable = false)
    private Epico epico;

    @Column(name = "nomearquivo", nullable = false)
    private String nomearquivo;

    @Column(name = "nomeoriginal", nullable = false)
    private String nomeoriginal;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "tipoarquivo", nullable = false)
    private String tipoarquivo;

    @Column(name = "tamanho", nullable = false)
    private int tamanho;

    @Column(name = "caminho", nullable = false)
    private String caminho;

    @Column(name = "dataupload")
    private LocalDate dataupload;

    @PrePersist
    public void prePersist() {
        dataupload = LocalDate.now();
    }
}