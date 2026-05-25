package br.com.taskboard.demo.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

@Getter
@Setter
@Entity
public class Tempo_gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtempo_gasto;
    private Long idtarefa;
    private Long idusuario;
    private Timestamp data_excucao;
    private Timestamp hora_excucao;
    private Long duracao;
}
