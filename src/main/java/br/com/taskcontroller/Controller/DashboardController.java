package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Projection.IndicadorEquipeProjection;
import br.com.taskcontroller.Service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;
    @GetMapping("/{idEmpreendimento}/dashboard_equipes")
    public List<IndicadorEquipeProjection> buscarIndicadoresEquipe(@PathVariable Long idEmpreendimento) {
          return dashboardService.buscarIndicadoresEquipe(idEmpreendimento);
    }
}