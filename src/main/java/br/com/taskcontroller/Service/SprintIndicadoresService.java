package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Record.Equipe.EquipeEmpreendimentoDTO;
import br.com.taskcontroller.Record.Sprint.SprintIndicadoresDTO;
import br.com.taskcontroller.Respository.EquipeRepository;
import br.com.taskcontroller.Respository.EquipeUsuarioRepository;
import br.com.taskcontroller.Respository.SprintRepository;
import br.com.taskcontroller.Respository.TarefaRepository;
import br.com.taskcontroller.Utilidades.ResolveTempo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SprintIndicadoresService {

    private final SprintRepository sprintRepository;
    private final SprintCapacidadeService sprintCapacidadeService;
    private final EquipeUsuarioRepository equipeUsuarioRepository;
    private final TarefaRepository tarefaRepository;

    public SprintIndicadoresDTO carregaIndicadores(Long idSprint) {
        ResolveTempo resolveTempo = new ResolveTempo();
        LocalDate hoje = LocalDate.now();
        Sprint sprint = sprintRepository.findById(idSprint).orElseThrow();

        BigDecimal horasDia = BigDecimal.valueOf(sprint.getEmpreendimento().getHoras_trabalho_dia());

        // INDICADORES DAS TAREFAS
        Long concluidas = sprintRepository.contarConcluidas(idSprint);

        Long emandamento = sprintRepository.contarEmAndamento(idSprint, hoje);

        Long atrasadas = sprintRepository.contarAtrasadas(idSprint, hoje);

        // USUÁRIOS DO EMPREENDIMENTO
        List<EquipeEmpreendimentoDTO> usuarios = equipeUsuarioRepository.buscarUsuariosEmpreendimento(sprint.getEmpreendimento().getIdempreendimento());

        // DIAS ÚTEIS DA SPRINT
        BigDecimal diasUteis = sprintCapacidadeService.calcularDiasUteis(sprint.getDtiniciosprint(), sprint.getDtfinalsprint());

        // CAPACIDADE POR USUÁRIO (HORAS)
        BigDecimal capacidade = diasUteis.multiply(horasDia);

        // CAPACIDADE BRUTA DA EQUIPE
        BigDecimal bruta = capacidade.multiply(BigDecimal.valueOf(usuarios.size()));

        // DIAS ÚTEIS DE AUSÊNCIA
        BigDecimal ausencias = sprintCapacidadeService.calcularAusencias(sprint, usuarios);

        // CONVERTER AUSÊNCIAS EM HORAS
        BigDecimal horasAusentes = ausencias.multiply(horasDia);

        // CAPACIDADE LÍQUIDA
        BigDecimal liquida = bruta.subtract(horasAusentes).max(BigDecimal.ZERO);

        // PERCENTUAL DE DISPONIBILIDADE
        BigDecimal porcentagem = BigDecimal.ZERO;

        if (bruta.compareTo(BigDecimal.ZERO) > 0) {
            porcentagem = liquida.divide(bruta,4, RoundingMode.HALF_UP);
        }
        // TOTAL DE HORAS ESTIMADAS
        BigDecimal horasEstimadas = tarefaRepository.somarHorasEstimadasSprint(idSprint);

        // OCUPAÇÃO DA SPRINT
        BigDecimal ocupacao = BigDecimal.ZERO;

        if (liquida.compareTo(BigDecimal.ZERO) > 0) {
            ocupacao = horasEstimadas
                    .multiply(BigDecimal.valueOf(100))
                    .divide(liquida, 2, RoundingMode.HALF_UP);
        }
        // SALDO DE HORAS
        BigDecimal saldoHoras = liquida.subtract(horasEstimadas);

        return new SprintIndicadoresDTO(
                concluidas,
                emandamento,
                atrasadas,
                capacidade,
                bruta,
                liquida,
                porcentagem,
                ausencias,
                resolveTempo.transformarParaHorasDecimais(horasEstimadas),
                resolveTempo.transformarParaHorasDecimais(ocupacao),
                resolveTempo.transformarParaHorasDecimais(saldoHoras)
        );
    }

}