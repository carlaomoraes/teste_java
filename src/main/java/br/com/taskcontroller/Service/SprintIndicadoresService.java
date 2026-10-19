package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Record.Equipe.EquipeEmpreendimentoDTO;
import br.com.taskcontroller.Record.Sprint.SprintIndicadoresDTO;
import br.com.taskcontroller.Respository.EquipeRepository;
import br.com.taskcontroller.Respository.EquipeUsuarioRepository;
import br.com.taskcontroller.Respository.SprintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SprintIndicadoresService {

    private final SprintRepository sprintRepository;
    private final SprintCapacidadeService sprintCapacidadeService;
    private final EquipeUsuarioRepository equipeUsuarioRepository;

    public SprintIndicadoresDTO carregaIndicadores(Long idSprint) {
        LocalDate hoje = LocalDate.now();
        Sprint sprint = sprintRepository.findById(idSprint).orElseThrow();
        BigDecimal horasDia = BigDecimal.valueOf(
                sprint.getEmpreendimento().getHoras_trabalho_dia()
        );

        Long concluidas = sprintRepository.contarConcluidas(idSprint);
        Long emandamento = sprintRepository.contarEmAndamento(idSprint, hoje);
        Long atrasadas =  sprintRepository.contarAtrasadas(idSprint, hoje);
        BigDecimal capacidade = sprintCapacidadeService.calcularDiasUteis(sprint.getDtiniciosprint(), sprint.getDtfinalsprint());
        capacidade = capacidade.multiply(horasDia);
        BigDecimal bruta = sprintCapacidadeService.calcularCapacidadeBruta(sprint);
        bruta = bruta.multiply(horasDia);
        BigDecimal liquida = bruta.subtract(capacidade);
        liquida = liquida.multiply(horasDia);
        BigDecimal porcentagem = liquida.divide(bruta, 2, BigDecimal.ROUND_HALF_UP);
        List<EquipeEmpreendimentoDTO> usuarios = equipeUsuarioRepository.buscarUsuariosEmpreendimento(sprint.getEmpreendimento().getIdempreendimento());

        BigDecimal ausencias = sprintCapacidadeService.calcularAusencias(sprint,usuarios);

        return new SprintIndicadoresDTO(
                concluidas,
                emandamento,
                atrasadas,
                capacidade,
                bruta,
                liquida,
                porcentagem,
                ausencias);
    }

}