package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.AusenciaProgramadaRequestDTO;
import br.com.taskcontroller.DTO.AusenciaProgramadaResponseDTO;
import br.com.taskcontroller.Modelo.AusenciaProgramada;
import br.com.taskcontroller.Modelo.Tipo_Ausencia;
import br.com.taskcontroller.Modelo.Usuario;

public class AusenciaProgramadaMapper {

    public static AusenciaProgramada toEntity(AusenciaProgramadaRequestDTO dto) {
        AusenciaProgramada a = new AusenciaProgramada();
        System.out.println(dto);
        a.setIdausencia(dto.getIdausencia());
        Usuario usuario = new Usuario();
        usuario.setIdusuario(dto.getIdusuario());
        a.setUsuario(usuario);
        Tipo_Ausencia tipoAusencia = new Tipo_Ausencia();
        tipoAusencia.setId_tipo_ausencia(dto.getId_tipo_ausencia());
        a.setTipoausencia(tipoAusencia);
        a.setData_inicio(dto.getData_inicio());
        a.setData_fim(dto.getData_fim());
        a.setObservacao(dto.getObservacao());
        a.setData_cadastro(dto.getData_cadastro());

        return a;
    }

    public static AusenciaProgramadaResponseDTO toDTO(AusenciaProgramada a) {
        AusenciaProgramadaResponseDTO dto = new AusenciaProgramadaResponseDTO();
        dto.setIdausencia(a.getIdausencia());
        Usuario usuario = new Usuario();
        usuario.setIdusuario(dto.getIdusuario());
        a.setUsuario(usuario);
        Tipo_Ausencia tipoAusencia = new Tipo_Ausencia();
        tipoAusencia.setId_tipo_ausencia(a.getTipoausencia().getId_tipo_ausencia());
        dto.setTipo_ausencia(tipoAusencia);

        dto.setData_inicio(a.getData_inicio());
        dto.setData_fim(a.getData_fim());
        dto.setObservacao(a.getObservacao());
        dto.setData_cadastro(a.getData_cadastro());
        dto.setData_inicio(a.getData_inicio());
        dto.setData_fim(a.getData_fim());
        dto.setObservacao(a.getObservacao());

        return dto;
    }
}
