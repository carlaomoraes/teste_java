package br.com.taskboard.demo.DTO;


import br.com.taskboard.demo.Modelo.Sistema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public class Etapa_sistemaResquestDTO {
    private Long idetapa_sistema;
    private String descetapa_sistema;
    private Sistema sistema;
    private int backlog;
}
