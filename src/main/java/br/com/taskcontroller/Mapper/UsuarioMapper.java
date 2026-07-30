package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.AusenciaProgramadaRequestDTO;
import br.com.taskcontroller.DTO.AusenciaProgramadaResponseDTO;
import br.com.taskcontroller.DTO.UsuarioRequestDTO;
import br.com.taskcontroller.DTO.UsuarioResponseDTO;
import br.com.taskcontroller.Modelo.AusenciaProgramada;
import br.com.taskcontroller.Modelo.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario u = new Usuario();
        u.setIdusuario(dto.getIdusuario());
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setSenha(dto.getSenha());
        u.setPapel(dto.getPapel());
        u.setAlterasenha(dto.isAlterasenha());
        u.setAtivo(dto.isAtivo());
        return u;
    }

    public static UsuarioResponseDTO toDTO(Usuario u) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());
        dto.setIdusuario(u.getIdusuario());
        dto.setSenha(u.getSenha());
        dto.setPapel(u.getPapel());
        dto.setAlterasenha(u.isAlterasenha());
        dto.setAtivo(u.isAtivo());
        return dto;
    }
}
