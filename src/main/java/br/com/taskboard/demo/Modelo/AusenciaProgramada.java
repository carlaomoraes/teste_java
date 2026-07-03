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
    private Long idausencia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario")
    private Usuario idusuario;
    @Column(name = "data_inicio") // Mapeia para o nome físico do banco caso esteja com o erro de digitação
    private LocalDate data_inicio;
    @Column(name = "data_fim") // Mapeia para o nome físico do banco caso esteja com o erro de digitação
    private LocalDate data_fim;
    @Column(name="observacao")
    private String observacao;
    @Column(name="status")
    private String status;
    @Column(name = "data_cadastro") // Mapeia para o nome físico do banco caso esteja com o erro de digitação
    private LocalDate data_cadastro;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_ausencia")
    private TipoAusencia tipoausencia;

    @PrePersist
    public void prePersist() {
        this.data_cadastro = LocalDate.now();
    }

    public Long getIdausencia() {
        return idausencia;
    }

    public void setIdausencia(Long idausencia) {
        this.idausencia = idausencia;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public void setData_fim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public TipoAusencia getTipoausencia() {
        return tipoausencia;
    }

    public void setTipoausencia(TipoAusencia tipoausencia) {
        this.tipoausencia = tipoausencia;
    }
}
