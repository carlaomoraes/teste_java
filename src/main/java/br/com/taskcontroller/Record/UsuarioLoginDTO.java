package br.com.taskcontroller.Record;

public record UsuarioLoginDTO(
        Long idusuario,
        String nome,
        String login,
        Long idpapel,
        Long idEmpreendimento
) {}