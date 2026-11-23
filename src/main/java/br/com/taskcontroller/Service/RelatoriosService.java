package br.com.taskcontroller.Service;

import br.com.taskcontroller.Record.Sprint.SprintListagemDTO;
import br.com.taskcontroller.Utilidades.ResolveTempo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO;
import br.com.taskcontroller.Respository.RelatoriosSprintRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
public class RelatoriosService {

    @Autowired
    private RelatoriosSprintRepository repository;

    public List<RelatorioSprintDTO> relatorioSprintPorEmpreendimento(
            Long idempreendimento) {

        ResolveTempo resolveTempo = new ResolveTempo();

        List<RelatorioSprintDTO> relatorios =
                repository.relatorioSprintPorEmpreendimento(idempreendimento);

        return relatorios.stream()
                .map(r -> {

                    BigDecimal estimadas = BigDecimal.valueOf(r.totalHorasEstimadas());
                    BigDecimal realizadas = BigDecimal.valueOf(r.totalHorasRealizadas());

                    BigDecimal progresso = BigDecimal.ZERO;

                    if (estimadas.compareTo(BigDecimal.ZERO) > 0) {
                        progresso = realizadas
                                .multiply(BigDecimal.valueOf(100))
                                .divide(estimadas, 2, RoundingMode.HALF_UP);
                    }

                    return new RelatorioSprintDTO(
                            r.idempreendimento(),
                            r.descempreendimento(),
                            r.idsprint(),
                            r.descsprint(),
                            r.dtiniciosprint(),
                            r.dtfinalsprint(),
                            r.descstatus(),
                            r.corstatus(),
                            r.contEstorias(),
                            r.contTarefas(),
                            r.totalHorasEstimadas(),
                            r.totalHorasRealizadas(),
                            resolveTempo.transformarToSexagesimal(estimadas.longValue()),
                            resolveTempo.transformarToSexagesimal(realizadas.longValue()),
                            progresso
                    );
                })
                .toList();
    }
    public List<RelatorioSprintDTO> relatorioSprintPorID(
            List<Long> idSprint) {

        ResolveTempo resolveTempo = new ResolveTempo();

        List<RelatorioSprintDTO> relatorios =
                repository.relatorioSprintPorID(idSprint);

        return relatorios.stream()
                .map(r -> {
                    BigDecimal estimadas = BigDecimal.valueOf(r.totalHorasEstimadas());
                    BigDecimal realizadas = BigDecimal.valueOf(r.totalHorasRealizadas());

                    BigDecimal progresso = BigDecimal.ZERO;

                    if (estimadas.compareTo(BigDecimal.ZERO) > 0) {

                        progresso = realizadas
                                .multiply(BigDecimal.valueOf(100))
                                .divide(estimadas, 2, RoundingMode.HALF_UP);
                    }

                    return new RelatorioSprintDTO(
                            r.idempreendimento(),
                            r.descempreendimento(),
                            r.idsprint(),
                            r.descsprint(),
                            r.dtiniciosprint(),
                            r.dtfinalsprint(),
                            r.descstatus(),
                            r.corstatus(),
                            r.contEstorias(),
                            r.contTarefas(),
                            r.totalHorasEstimadas(),
                            r.totalHorasRealizadas(),
                            resolveTempo.transformarToSexagesimal(estimadas.longValue()),
                            resolveTempo.transformarToSexagesimal(realizadas.longValue()),
                            progresso
                    );
                })
                .toList();
    }
    public List<RelatorioSprintDTO> relatorioSprintPorPeriodo(
            LocalDate data_inicial,
            LocalDate data_final) {

        ResolveTempo resolveTempo = new ResolveTempo();

        List<RelatorioSprintDTO> relatorios = repository.relatorioSprintPorPeriodo(data_inicial, data_final);

        return relatorios.stream()
                .map(r -> {
                    BigDecimal estimadas = BigDecimal.valueOf(r.totalHorasEstimadas());
                    BigDecimal realizadas = BigDecimal.valueOf(r.totalHorasRealizadas());

                    BigDecimal progresso = BigDecimal.ZERO;

                    if (estimadas.compareTo(BigDecimal.ZERO) > 0) {

                        progresso = realizadas
                                .multiply(BigDecimal.valueOf(100))
                                .divide(estimadas, 2, RoundingMode.HALF_UP);
                    }

                    return new RelatorioSprintDTO(
                            r.idempreendimento(),
                            r.descempreendimento(),
                            r.idsprint(),
                            r.descsprint(),
                            r.dtiniciosprint(),
                            r.dtfinalsprint(),
                            r.descstatus(),
                            r.corstatus(),
                            r.contEstorias(),
                            r.contTarefas(),
                            r.totalHorasEstimadas(),
                            r.totalHorasRealizadas(),
                            resolveTempo.transformarToSexagesimal(estimadas.longValue()),
                            resolveTempo.transformarToSexagesimal(realizadas.longValue()),
                            progresso
                    );
                })
                .toList();
    }

    public List<SprintListagemDTO> listarSprints() {
        return repository.listarSprints();
    }
}