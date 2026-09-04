package br.com.taskcontroller.Mapper;


import br.com.taskcontroller.DTO.StatusEntidadesRequestDTO;
import br.com.taskcontroller.DTO.StatusEntidadesResponseDTO;
import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.TipoEntidade;

public class StatusEntidadesMapper {

    public static StatusEntidades toEntity(StatusEntidadesRequestDTO dto) {
        StatusEntidades s = new StatusEntidades();
        s.setIdstatus(dto.getIdstatus());
        TipoEntidade t = new TipoEntidade();
        t.setIdtipo_entidade(dto.getIdstatus());
        s.setTipoentidade(t);
        Empreendimento e = new Empreendimento();
        e.setIdempreendimento(dto.getEmpreendimento().getIdempreendimento());
        s.setEmpreendimento(e);
        s.setDescstatus(dto.getDescstatus());
        s.setOrdem(dto.getOrdem());
        s.setCor(dto.getCor());
        s.setInicial(dto.getInicial());
        s.setFinalizado(dto.getFinalizado());
        s.setCancelado(dto.getCancelado());
        s.setAtivo(dto.getAtivo());
        return s;
    }

    public static StatusEntidadesResponseDTO toDTO(StatusEntidades s) {
        StatusEntidadesResponseDTO dto = new StatusEntidadesResponseDTO();
        dto.setIdstatus(s.getIdstatus());
        TipoEntidade t = new TipoEntidade();
        t.setIdtipo_entidade(s.getIdstatus());
        s.setTipoentidade(t);
        Empreendimento e = new Empreendimento();
        e.setIdempreendimento(s.getEmpreendimento().getIdempreendimento());
        s.setEmpreendimento(e);
        s.setDescstatus(s.getDescstatus());
        s.setOrdem(s.getOrdem());
        s.setCor(s.getCor());
        s.setInicial(s.getInicial());
        s.setFinalizado(s.getFinalizado());
        s.setCancelado(s.getCancelado());
        s.setAtivo(s.getAtivo());
        return dto;
    }
}
