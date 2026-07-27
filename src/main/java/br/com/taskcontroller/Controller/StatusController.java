package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Record.StatusDTO;
import br.com.taskcontroller.Service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status_entidades")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;

    @GetMapping("/{idStatusAtual}/proximo")
    public List<StatusDTO> buscarProximoStatus(@PathVariable Long idStatusAtual) {
          return statusService.buscarProximosStatus(idStatusAtual)
                  .stream()
                  .map(s -> new StatusDTO(
                          s.getIdstatus(),
                          s.getDescstatus(),
                          s.getCor())).toList();
    }
}