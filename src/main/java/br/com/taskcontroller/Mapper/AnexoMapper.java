package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.AnexoRequestDTO;
import br.com.taskcontroller.DTO.AnexoResponseDTO;
import br.com.taskcontroller.Modelo.Anexo;

public class AnexoMapper {

    public static Anexo toEntity(AnexoRequestDTO dto) {
        Anexo a = new Anexo();
        a.setIdanexo(dto.getIdanexo());
        a.setEpico(dto.getEpico());
        a.setUsuario(dto.getUsuario());
        a.setNomearquivo(dto.getNomearquivo());
        a.setNomeoriginal(dto.getNomeoriginal());
        a.setDescricao(dto.getDescricao());
        a.setCategoria(dto.getCategoria());
        a.setTipoarquivo(dto.getTipoarquivo());
        a.setTamanho(dto.getTamanho());
        a.setCaminho(dto.getCaminho());
        a.setDataupload(dto.getDataupload());
        return a;
    }

    public static AnexoResponseDTO toDTO(Anexo a) {
        AnexoResponseDTO dto = new AnexoResponseDTO();
        dto.setIdanexo(a.getIdanexo());
        dto.setEpico(a.getEpico());
        dto.setUsuario(a.getUsuario());
        dto.setNomearquivo(a.getNomearquivo());
        dto.setNomeoriginal(a.getNomeoriginal());
        dto.setDescricao(a.getDescricao());
        dto.setCategoria(a.getCategoria());
        dto.setTipoarquivo(a.getTipoarquivo());
        dto.setTamanho(a.getTamanho());
        dto.setCaminho(a.getCaminho());
        dto.setDataupload(a.getDataupload());

        return dto;
    }
}
