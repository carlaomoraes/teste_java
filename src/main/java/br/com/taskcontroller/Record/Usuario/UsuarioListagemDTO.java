package br.com.taskcontroller.Record.Usuario;

public record UsuarioListagemDTO(
        Long idusuario,
        String nome,
        String login,
        String senha,
        String email,
        Boolean ativo,
        Boolean alterasenha,
        Long idPapel,
        String nomePapel,
        Long idEmpreendimento,
        String nomeEmpreendimento
) {
}
