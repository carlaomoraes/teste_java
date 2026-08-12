package br.com.taskcontroller.Record.Usuario;

public record UsuarioLoginDTO(
        Long idusuario,
        String nome,
        String login,
        Long idpapel
) {}