package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.AusenciaProgramada;
import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Record.Ausencia.AusenciaListagemDTO;
import br.com.taskcontroller.Record.Ausencia.AusenciaSprintDTO;
import br.com.taskcontroller.Record.Equipe.EquipeEmpreendimentoDTO;
import br.com.taskcontroller.Record.Equipe.EquipeUsuarioDTO;
import br.com.taskcontroller.Respository.AusenciaProgramadaRepository;
import br.com.taskcontroller.Respository.EquipeUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SprintCapacidadeService {

    private final SprintService sprintService;
    private final EquipeUsuarioRepository equipeUsuarioRepository;
    private final AusenciaProgramadaRepository ausenciaProgramadaRepository;

    public BigDecimal calcularDiasUteis(LocalDate inicio,LocalDate fim) {
        BigDecimal dias = BigDecimal.ZERO;
        for (LocalDate data = inicio; !data.isAfter(fim); data = data.plusDays(1)) {
            if (!sprintService.ehFimDeSemana(data)) {
                dias = dias.add(BigDecimal.valueOf(1));
            }
        }
        return dias;
    }

    public BigDecimal calcularFimdeSemana(LocalDate inicio,LocalDate fim) {
        BigDecimal dias = BigDecimal.ZERO;
        for (LocalDate data = inicio; !data.isAfter(fim); data = data.plusDays(1)) {
            if (!sprintService.ehFimDeSemana(data)) {
                dias = dias.add(BigDecimal.valueOf(1));
            }
        }
        return dias;
    }


    public BigDecimal calcularCapacidadeBruta(Sprint sprint) {
        BigDecimal diasUteis = calcularDiasUteis(sprint.getDtiniciosprint(),sprint.getDtfinalsprint());

        BigDecimal horasDia = BigDecimal.valueOf(sprint.getEmpreendimento().getHoras_trabalho_dia());

        Long idEmpreendimento = sprint.getEmpreendimento().getIdempreendimento();

        List<EquipeEmpreendimentoDTO> usuarios = equipeUsuarioRepository.buscarUsuariosEmpreendimento(idEmpreendimento);

        BigDecimal ausencias = calcularAusencias(sprint, usuarios);

        return ausencias.multiply(horasDia.multiply(diasUteis).multiply(BigDecimal.valueOf(usuarios.stream().count())));
    }
    public BigDecimal calcularAusencias(Sprint sprint, List<EquipeEmpreendimentoDTO> usuarios) {
        long totalDiasAusentes = 0;
        for (EquipeEmpreendimentoDTO usuario : usuarios) {
            List<AusenciaSprintDTO> ausencias  =
                    ausenciaProgramadaRepository.buscarAusenciasDaSprintPorUsuario(
                                    sprint.getDtiniciosprint(),
                                    sprint.getDtfinalsprint(),
                                    usuario.idusuario()
                            );

            Set<LocalDate> diasAusentes = new HashSet<>();

            for (AusenciaSprintDTO ausencia : ausencias) {
                LocalDate inicio = ausencia.data_inicio().isBefore(sprint.getDtiniciosprint()) ? sprint.getDtiniciosprint() : ausencia.data_inicio();

                LocalDate fim = ausencia.data_fim().isAfter(sprint.getDtfinalsprint()) ? sprint.getDtfinalsprint() : ausencia.data_fim();

                for (LocalDate data = inicio; !data.isAfter(fim); data = data.plusDays(1)) {
                    DayOfWeek dia = data.getDayOfWeek();
                    if (dia != DayOfWeek.SATURDAY && dia != DayOfWeek.SUNDAY) {
                        diasAusentes.add(data);
                    }
                }
            }

            totalDiasAusentes += diasAusentes.size();
        }

        return BigDecimal.valueOf(totalDiasAusentes);
    }
}