package br.com.taskcontroller.Record;

public record UsuarioAutenticacaoDTO(
        Long idusuario,
        String nome,
        String login,
        String senha,
        Long idPapel,
        Long idEmpreendimento
) {}