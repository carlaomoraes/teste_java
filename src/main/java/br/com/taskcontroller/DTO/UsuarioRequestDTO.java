package br.com.taskcontroller.DTO;

import br.com.taskcontroller.Modelo.Papel;

public class UsuarioRequestDTO {
    private Long idusuario;
    private String nome;
    private String login;
    private String email;
    private String senha;
    private Papel papel;
    private int alterasenha;
    // Getters e Setters
}