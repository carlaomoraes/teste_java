package br.com.taskcontroller.Controller;

import br.com.taskcontroller.DTO.PapelRequestDTO;
import br.com.taskcontroller.DTO.StatusEntidadesRequestDTO;
import br.com.taskcontroller.Mapper.PapelMapper;
import br.com.taskcontroller.Mapper.StatusEntidadesMapper;
import br.com.taskcontroller.Modelo.Papel;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Record.Status.StatusDTO;
import br.com.taskcontroller.Record.Status.StatusEntidadesListagemDTO;
import br.com.taskcontroller.Record.Status.TipoEntidadeDTO;
import br.com.taskcontroller.Service.StatusService;
import br.com.taskcontroller.Service.TipoEntidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status_entidades")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;
    private final TipoEntidadeService tipoEntidadeService;

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody StatusEntidadesRequestDTO dto) {
        StatusEntidades statusEntidades = StatusEntidadesMapper.toEntity(dto);
        return ResponseEntity.ok().body(statusService.salvar(statusEntidades));
    }

    @GetMapping("/{idStatusAtual}/proximo")
    public List<StatusDTO> buscarProximoStatus(@PathVariable Long idStatusAtual) {
          return statusService.buscarProximosStatus(idStatusAtual)
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
}