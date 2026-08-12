package br.com.taskcontroller.Record.Usuario;

public record UsuarioInclusaoDTO(
        String nome,
        String login,
        String senha,
        String email,
        Long idpapel,
        int ativo
) {
}
