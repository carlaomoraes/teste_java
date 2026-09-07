package br.com.taskcontroller.Mapper;


import br.com.taskcontroller.DTO.StatusEntidadesRequestDTO;
import br.com.taskcontroller.DTO.StatusEntidadesResponseDTO;
import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.TipoEntidade;
import br.com.taskcontroller.Service.EmpreendimentoService;
import br.com.taskcontroller.Service.TipoEntidadeService;
import org.springframework.beans.factory.annotation.Autowired;

public class StatusEntidadesMapper {

    @Autowired
    private static TipoEntidadeService tipoEntidadeService;

    @Autowired
    private static EmpreendimentoService empreendimentoService;


    public static StatusEntidades toEntity(StatusEntidadesRequestDTO dto) {
        StatusEntidades s = new StatusEntidades();
        s.setIdstatus(dto.getIdstatus());
        TipoEntidade t = tipoEntidadeService.buscarPorId(dto.getIdstatus());
        s.setTipoentidade(t);
        Empreendimento e = empreendimentoService.buscarPorId(dto.getEmpreendimento().getIdempreendimento());
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
        dto.setIdstatus(s.getIdstatus());
        dto.setIdempreendimento(dto.getIdempreendimento());
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
