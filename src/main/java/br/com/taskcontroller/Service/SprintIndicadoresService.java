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
    private final SprintSaudeService sprintSaudeService;
    private final EquipeUsuarioRepository equipeUsuarioRepository;
    private final TarefaRepository tarefaRepository;
    private final SprintCapacidadeService  capacidadeService;

    public SprintIndicadoresDTO carregaIndicadores(Long idSprint) {
        ResolveTempo resolveTempo = new ResolveTempo();
        String saude;

        LocalDate hoje = LocalDate.now();

        Sprint sprint = sprintRepository.findById(idSprint).orElseThrow();

        BigDecimal horasDia = BigDecimal.valueOf(sprint.getEmpreendimento().getHoras_trabalho_dia());

        // INDICADORES DAS TAREFAS
        Long concluidas = sprintRepository.contarConcluidas(idSprint);

        Long emandamento = sprintRepository.contarEmAndamento(idSprint, hoje);

        Long atrasadas = sprintRepository.contarAtrasadas(idSprint, hoje);

        Long totalTarefa = concluidas + emandamento + atrasadas;

        BigDecimal progressoReal = calcularProgressoReal(idSprint);

        BigDecimal progessoEsperado = calcularProgressoEsperado(sprint);

        BigDecimal delta = progressoReal.subtract(progessoEsperado);

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

        //SAÚDE DA SPRINT
        saude = sprintSaudeService.calcularSaude(totalTarefa, progessoEsperado,progressoReal,delta);

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
                resolveTempo.transformarParaHorasDecimais(saldoHoras),
                saude,
                progessoEsperado,
                progressoReal,
                delta
                );
    }
    public BigDecimal calcularProgressoEsperado(Sprint sprint) {
        LocalDate inicio = sprint.getDtiniciosprint();
        LocalDate fim = sprint.getDtfinalsprint();
        LocalDate hoje = LocalDate.now();

        // Sprint ainda não começou
        if (hoje.isBefore(inicio)) {
            return BigDecimal.ZERO;
        }

        // Sprint chegou ao fim
        if (hoje.isAfter(fim)) {
            return BigDecimal.valueOf(100);
        }

        BigDecimal diasTotais = sprintCapacidadeService.calcularDiasUteis(inicio, fim);

        BigDecimal diasDecorridos = sprintCapacidadeService.calcularDiasUteis(inicio, hoje);

        if (diasTotais.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        return diasDecorridos
                .multiply(BigDecimal.valueOf(100))
                .divide(diasTotais, 2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcularProgressoReal(Long idSprint) {
        Long concluidas = tarefaRepository.contarConcluidas(idSprint);
        Long total = tarefaRepository.contarTotalTarefas(idSprint);

        if (total == 0) {
            return BigDecimal.ZERO;
        }

        return BigDecimal.valueOf(concluidas)
                .multiply(BigDecimal.valueOf(100))
                .divide(
                        BigDecimal.valueOf(total),
                        2,
                        RoundingMode.HALF_UP
                );
    }
}