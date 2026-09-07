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
    public static EmpreendimentoService empreendimentoService;


    public static StatusEntidades toEntity(StatusEntidadesRequestDTO dto) {
        StatusEntidades s = new StatusEntidades();
   //     s.setIdstatus(dto.getIdstatus());
        TipoEntidade t = tipoEntidadeService.buscarPorId(dto.getIdstatus());
        s.setTipoentidade(t);
        Empreendimento e = empreendimentoService.buscarPorId(dto.getIdempreendimento());
        s.setEmpreendimento(e);
        s.setDescstatus(dto.getDescstatus());
        s.setOrdem(dto.getOrdem());
        s.setCor(dto.getCor());
        s.setInicial(dto.isInicial());
        s.setFinalizado(dto.isFinalizado());
        s.setCancelado(dto.isCancelado());
        s.setAtivo(dto.isAtivo());
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
        s.setInicial(s.isInicial());
        s.setFinalizado(s.isFinalizado());
        s.setCancelado(s.isCancelado());
        s.setAtivo(s.isAtivo());
        return dto;
    }
}
