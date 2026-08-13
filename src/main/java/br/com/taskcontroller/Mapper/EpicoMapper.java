package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.EpicoRequestDTO;
import br.com.taskcontroller.DTO.EpicoResponseDTO;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Epico.EpicoInclusaoDTO;

public class EpicoMapper {

    public static Epico toEntity(EpicoInclusaoDTO dto) {
        Epico e = new Epico();
        Empreendimento empreendimento = new Empreendimento();
        empreendimento.setIdempreendimento(dto.idempreendimento());
        e.setEmpreendimento(empreendimento);
        Usuario usuario = new Usuario();
        usuario.setIdusuario(dto.idresponsavel());
        e.setResponsavel(usuario);
        Prioridades prioridades = new Prioridades();
        prioridades.setIdprioridade(dto.idprioridade());
        e.setPrioridade(prioridades);
        StatusEntidades statusEntidades = new StatusEntidades();
        statusEntidades.setIdstatus(dto.idstatus());
        e.setStatus(statusEntidades);
        e.setBloqueado(dto.bloqueado());
        e.setData_inicio(dto.data_inicialEP());
        e.setData_fim_prevista(dto.data_fim_previstaEP());
        e.setCodepico(dto.codepico());
        e.setNome(dto.nome());
        e.setCor(dto.cor());
        e.setPercentual(dto.percentual());
        e.setAtivo(dto.ativo());
        return e;
    }

    public static EpicoResponseDTO toDTO(Epico e) {
        EpicoResponseDTO dto = new EpicoResponseDTO();
        dto.setIdepico(e.getIdepico());
        dto.setNome(e.getNome());
        dto.setEmpreendimento(e.getEmpreendimento());
        dto.setResponsavel(e.getResponsavel());
        dto.setPrioridade(e.getPrioridade());
        dto.setStatus(e.getStatus());
        dto.setBloqueado(e.getBloqueado());
        dto.setData_cadastro(e.getData_cadastro());
        dto.setData_inicio(e.getData_inicio());
        dto.setData_fim_prevista(e.getData_fim_prevista());
        dto.setCodepico(e.getCodepico());
        dto.setCor(e.getCor());
        dto.setPercentual(e.getPercentual());
        dto.setAtivo(e.getAtivo());
        return dto;
    }
}
