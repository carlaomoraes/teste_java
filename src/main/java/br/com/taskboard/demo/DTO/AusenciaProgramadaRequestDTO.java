package br.com.taskboard.demo.DTO;

import br.com.taskboard.demo.Modelo.TipoAusencia;
import br.com.taskboard.demo.Modelo.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;

public class AusenciaProgramadaRequestDTO {
    private Long idausencia;
    private Usuario idusuario;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private String observacao;
    private String status;
    private LocalDate data_cadastro;
    private TipoAusencia tipoausencia;
}
