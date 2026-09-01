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
        e.setOrdem(dto.getOrdem());
        return e;
    }

    public static EstoriaInclusaoDTO toDTO(Estoria e) {
        EstoriaInclusaoDTO dto = new EstoriaInclusaoDTO();
        dto.setIdestoria(e.getIdestoria());
        dto.setIdestoria(e.getIdestoria());
        dto.setIdepico(e.getEpico().getIdepico());
        dto.setIdcriador(e.getCriador().getIdusuario());
        dto.setIdresponsavel(e.getResponsavel().getIdusuario());
        dto.setIdstatus(e.getStatus().getIdstatus());
        dto.setBloqueada(e.isBloqueada());
        dto.setResumo(e.getResumo());
        dto.setData_inicio(e.getData_inicio());
        dto.setData_fim(e.getData_fim());
        dto.setPontos(e.getPontos());
        dto.setHoras_estimadas(e.getHoras_estimadas());
        dto.setHoras_realizadas(e.getHoras_realizadas());
        dto.setAtiva(e.isAtiva());
        dto.setIdempreendiemnto_equipe(e.getEmpreendimentoEquipe().getIdempreendimento_equipe());
        dto.setTags(e.getTags());
        dto.setCriterios(e.getCriterios());
        dto.setOrdem(e.getOrdem());
        return dto;
    }
}
