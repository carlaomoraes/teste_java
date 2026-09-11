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
        StatusEntidades status = StatusEntidadesMapper.toEntity(dto);
        return ResponseEntity.ok(service.salvar(status));
    }
    // SALVAR
    @PostMapping("/salvartransicao")
    public ResponseEntity<?> salvarTransicao(@RequestBody StatusTransicaoRequestDTO dto) {
        StatusTransicao status = StatusTransicaoMapper.toEntity(dto);
        return ResponseEntity.ok(statusTransicaoService.salvar(status));
    }

    @GetMapping("/proximo")
    public List<StatusDTO> buscarProximoStatus(@RequestParam("idStatusAtual") Long idStatusAtual,
                                               @RequestParam("idTipoEntidade") Long idTipoEntidade,
                                               @RequestParam("idEmpreendimento") Long idEmpreendimento) {
          return service.buscarProximosStatus(idStatusAtual, idTipoEntidade, idEmpreendimento)
                  .stream()
                  .map(s -> new StatusDTO(
                          s.getIdstatus(),
                          s.getDescstatus(),
                          s.getCor())).toList();
    }

    @GetMapping("/DTO/montaComboTipoEntidades")
    public List<TipoEntidadeDTO> montaComboTipoEntidade() {
        return tipoEntidadeService.montaComboTipoEntidade();
    }
    @GetMapping("/DTO/{idStatus}")
    public StatusEntidadesListagemDTO buscarPorLinha(@PathVariable Long idStatus) {
        return tipoEntidadeService.buscarPorLinha(idStatus);
    }

    @GetMapping("/listar/{idEmpreendimento}")
    public List<StatusEntidadesListagemDTO> listar(@PathVariable Long idEmpreendimento) {
        return tipoEntidadeService.listar(idEmpreendimento);
    }
    // Retorna a proxima ordem baseado no Empreendimento e na Entidade
    @GetMapping("/proximaordem")
    public int proximaOrdem(@RequestParam("idEmpreendimento") Long idEmpreendimento,
                            @RequestParam("idStatusEntidade") Long idStatusEntidade) {
        return tipoEntidadeService.proximaOrdem(idEmpreendimento, idStatusEntidade);
    }

    @GetMapping("/listatransicao")
    public List<TipoEntidadeDTO> montaComboOrigem(@RequestParam("idEmpreendimento") Long idEmpreendimento,
                                                  @RequestParam("idTipoEntidade") Long idTipoEntidade) {
        return statusEntidadesService.montaComboOrigem(idEmpreendimento, idTipoEntidade);
    }
    @GetMapping("/montatransicao")
    public List<StatusTransicaoDTO> montaTransicao(@RequestParam("idEmpreendimento") Long idEmpreendimento,
                                                   @RequestParam("idTipoEntidade") Long idTipoEntidade) {
        return statusTransicaoService.montaTransicao(idEmpreendimento, idTipoEntidade);
    }

    @GetMapping("/proximosstatus")
    public List<StatusTransicaoDTO> mostraProximosStatus(@RequestParam("idEmpreendimento") Long idEmpreendimento,
                                                         @RequestParam("idTipoEntidade") Long idTipoEntidade,
                                                         @RequestParam("idStatus") Long idStatus) {
        return statusTransicaoService.mostraProximosStatus(idEmpreendimento, idTipoEntidade, idStatus);
    }
}