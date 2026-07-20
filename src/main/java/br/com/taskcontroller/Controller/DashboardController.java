package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Excecoes.BusinessRuleException;
import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.AusenciaProgramada;
import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Projection.IndicadorEquipeProjection;
import br.com.taskcontroller.Respository.AusenciaProgramadaRepository;
import br.com.taskcontroller.Respository.SprintRepository;
import br.com.taskcontroller.Service.DashboardService;
import br.com.taskcontroller.Service.EmpreendimentoService;
import br.com.taskcontroller.Service.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
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