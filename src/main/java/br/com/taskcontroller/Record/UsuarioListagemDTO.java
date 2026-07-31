package br.com.taskcontroller.Record;

public record UsuarioListagemDTO(
        Long idusuario,
        String nome,
        String login,
        String email,
        Boolean ativo,
        Boolean alterasenha,
        Long idPapel,
        String nomePapel,
        Long idEmpreendimento,
        String nomeEmpreendimento
) {
}
