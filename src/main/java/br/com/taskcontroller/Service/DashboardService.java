package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.AusenciaProgramada;
import br.com.taskcontroller.Projection.IndicadorEquipeProjection;
import br.com.taskcontroller.Respository.AusenciaProgramadaRepository;
import br.com.taskcontroller.Respository.DashboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final DashboardRepository dashboardRepository;

    public List<IndicadorEquipeProjection> buscarIndicadoresEquipe(Long  idEmpreendiemto) {
        return dashboardRepository.buscarIndicadoresEquipe(idEmpreendiemto);
    }
}