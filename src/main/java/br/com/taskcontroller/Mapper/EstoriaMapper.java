package br.com.taskcontroller.Mapper;


import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Estoria.EstoriaInclusaoDTO;

public class EstoriaMapper {

    public static Estoria toEntity(EstoriaInclusaoDTO dto) {
        Estoria e = new Estoria();
        e.setIdestoria(dto.getIdestoria());
        e.setIdestoria(dto.getIdestoria());
        Epico epico = new Epico();
        epico.setIdepico(dto.getIdepico());
        e.setEpico(epico);
        Usuario criador = new Usuario();
        criador.setIdusuario(dto.getIdcriador());
        e.setCriador(criador);
        Usuario responsavel = new Usuario();
        responsavel.setIdusuario(dto.getIdresponsavel());
        e.setResponsavel(responsavel);
        StatusEntidades status = new StatusEntidades();
        status.setIdstatus(dto.getIdstatus());
        e.setStatus(status);
        e.setBloqueada(dto.isBloqueada());
        e.setResumo(dto.getResumo());
        e.setData_inicio(dto.getData_inicio());
        e.setData_fim(dto.getData_fim());
        e.setPontos(dto.getPontos());
        e.setHoras_estimadas(dto.getHoras_estimadas());
        e.setHoras_realizadas(dto.getHoras_realizadas());
        e.setAtiva(dto.isAtiva());
        Empreendimento_Equipe empreendimento = new Empreendimento_Equipe();
        empreendimento.setIdempreendimento_equipe(dto.getIdempreendiemnto_equipe());
        e.setTags(dto.getTags());
        e.setCriterios(dto.getCriterios());
        return e;
    }

    public static EstoriaInclusaoDTO toDTO(Estoria e) {
        EstoriaInclusaoDTO dto = new EstoriaInclusaoDTO();
        dto.setIdestoria(dto.getIdestoria());
        dto.setIdestoria(dto.getIdestoria());
        dto.setIdepico(dto.getIdepico());
        dto.setIdcriador(dto.getIdcriador());
        dto.setIdresponsavel(dto.getIdresponsavel());
        dto.setIdstatus(e.getStatus().getIdstatus());
        dto.setBloqueada(dto.isBloqueada());
        dto.setResumo(dto.getResumo());
        dto.setData_inicio(dto.getData_inicio());
        dto.setData_fim(dto.getData_fim());
        dto.setPontos(dto.getPontos());
        dto.setHoras_estimadas(dto.getHoras_estimadas());
        dto.setHoras_realizadas(dto.getHoras_realizadas());
        dto.setAtiva(dto.isAtiva());
        dto.setIdempreendiemnto_equipe(dto.getIdempreendiemnto_equipe());
        dto.setTags(dto.getTags());
        dto.setCriterios(dto.getCriterios());
        return dto;
    }
}
