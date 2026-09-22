package br.com.taskcontroller.Controller;

import br.com.taskcontroller.DTO.StatusEntidadesRequestDTO;
import br.com.taskcontroller.DTO.StatusTransicaoRequestDTO;
import br.com.taskcontroller.Mapper.StatusEntidadesMapper;
import br.com.taskcontroller.Mapper.StatusTransicaoMapper;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Status.StatusDTO;
import br.com.taskcontroller.Record.Status.StatusEntidadesListagemDTO;
import br.com.taskcontroller.Record.Status.StatusTransicaoDTO;
import br.com.taskcontroller.Record.Status.TipoEntidadeDTO;
import br.com.taskcontroller.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status_entidades")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService service;
    private final TipoEntidadeService tipoEntidadeService;
    private final StatusTransicaoService statusTransicaoService;
    private final StatusEntidadesService statusEntidadesService;

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody StatusEntidadesRequestDTO dto) {
        StatusEntidades status;
        if(dto.getIdstatus() == null){
            status = StatusEntidadesMapper.toEntity(dto);
        }
        else {
            status = statusEntidadesService.buscarPorId(dto.getIdstatus());
            TipoEntidade tipo = tipoEntidadeService.buscarPorId(dto.getIdtipoentidade());
            status.setTipoentidade(tipo);
            status.setDescstatus(dto.getDescstatus());
            status.setOrdem(dto.getOrdem());
            status.setCor(dto.getCor());
            status.setInicial(dto.isInicial());
            status.setFinalizado(dto.isFinalizado());
            status.setCancelado(dto.isCancelado());
            status.setAtivo(dto.isAtivo());
        }
        return ResponseEntity.ok(service.salvar(status));
    }
    // SALVAR
    @PostMapping("/salvartransicao")
    public ResponseEntity<?> salvarTransicao(@RequestBody StatusTransicaoRequestDTO dto) {
        StatusTransicao status = StatusTransicaoMapper.toEntity(dto);
        return ResponseEntity.ok(statusTransicaoService.salvar(status));
    }

    @GetMapping("{idStatusAtual}/proximo/{idTipoEntidade}")
    public List<StatusTransicaoDTO> buscarProximoStatus(@PathVariable("idStatusAtual") Long idStatusAtual,
                                               @PathVariable("idTipoEntidade") Long idTipoEntidade) {
          return service.buscarProximosStatus(idStatusAtual, idTipoEntidade);
    }

    @GetMapping("/DTO/montaComboTipoEntidades")
    public List<TipoEntidadeDTO> montaComboTipoEntidade() {
        return tipoEntidadeService.montaComboTipoEntidade();
    }
    @GetMapping("/DTO/{idStatus}")
    public StatusEntidadesListagemDTO buscarPorLinha(@PathVariable Long idStatus) {
        return tipoEntidadeService.buscarPorLinha(idStatus);
    }

    @GetMapping("/listar/{idTipoEntidade}")
    public List<StatusEntidadesListagemDTO> listar(@PathVariable Long idTipoEntidade) {
        return tipoEntidadeService.listar(idTipoEntidade);
    }
    // Retorna a proxima ordem baseado no Empreendimento e na Entidade
    @GetMapping("/proximaordem/{idTipoEntidade}")
    public int proximaOrdem(@PathVariable Long idTipoEntidade) {
        return tipoEntidadeService.proximaOrdem(idTipoEntidade);
    }

    @GetMapping("/listatransicao")
    public List<TipoEntidadeDTO> montaComboOrigem(@RequestParam("idTipoEntidade") Long idTipoEntidade) {
        return statusEntidadesService.montaComboOrigem(idTipoEntidade);
    }

    @GetMapping("/disponiveis-transicao")
    List<StatusDTO> mostraDisponiveis(@RequestParam("idTipoEntidade") Long idTipoEntidade,
                                      @RequestParam("idStatusOrigem") Long idStatusOrigem) {
        return statusEntidadesService.mostraStatusDisponiveis(idTipoEntidade, idStatusOrigem);
    }

    @GetMapping("/acharOrigem")
    Long achaOrigem(@RequestParam("idTipoEntidade") Long idTipoEntidade) {
        return statusEntidadesService.achaOrigem(idTipoEntidade);
    }
}