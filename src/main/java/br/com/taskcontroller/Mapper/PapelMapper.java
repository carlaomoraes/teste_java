package br.com.taskcontroller.Mapper;


import br.com.taskcontroller.DTO.Etapa_sistemaResponseDTO;
import br.com.taskcontroller.DTO.Etapa_sistemaResquestDTO;
import br.com.taskcontroller.DTO.PapelRequestDTO;
import br.com.taskcontroller.DTO.PapelResponseDTO;
import br.com.taskcontroller.Modelo.Etapa_sistema;
import br.com.taskcontroller.Modelo.Papel;

public class PapelMapper {

    public static Papel toEntity(PapelRequestDTO dto) {
        Papel p = new Papel();
        p.setIdpapel(dto.getIdpapel());
        p.setDescpapel(dto.getDescpapel());
        p.setValorhora(dto.getValorhora());
        p.setTipopapel(dto.getTipopapel());
        p.setAtivo(dto.isAtivo());
        return p;
    }

    public static PapelResponseDTO toDTO(Papel p) {
        PapelResponseDTO dto = new PapelResponseDTO();
        dto.setIdpapel(p.getIdpapel());
        dto.setDescpapel(p.getDescpapel());
        dto.setValorhora(p.getValorhora());
        dto.setTipopapel(p.getTipopapel());
        dto.setAtivo(p.isAtivo());
        return dto;
    }
}
