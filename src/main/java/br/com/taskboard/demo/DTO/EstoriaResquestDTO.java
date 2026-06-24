package br.com.taskboard.demo.DTO;

import br.com.taskboard.demo.Enuns.Prioridade;
import br.com.taskboard.demo.Modelo.Epico;
import br.com.taskboard.demo.Modelo.Usuario;

public class EstoriaResquestDTO {
    private Long idestoria;
    private String descestoria;
    private Usuario idcriador;
    private Usuario idresponsavel;
    private Epico idepico;
    private Boolean bloqueada;
    private Prioridade status;
}
