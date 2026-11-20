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

                    Long estimadas;
                    Long realizadas;
                    try {
                        estimadas = r.totalHorasEstimadas();
                        realizadas = r.totalHorasRealizadas();
                    } catch (Exception e) {
                        estimadas = 0L;
                        realizadas = 0L;
                    }
                    BigDecimal progresso = BigDecimal.ZERO;

                    if (estimadas != null && estimadas> 0 && realizadas != null) {
                        progresso = BigDecimal.valueOf(realizadas).multiply(BigDecimal.valueOf(100).divide(BigDecimal.valueOf(estimadas), 2,RoundingMode.HALF_UP));
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
                            resolveTempo.transformarToSexagesimal(estimadas),
                            resolveTempo.transformarToSexagesimal(realizadas),
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
                    Long estimadas;
                    Long realizadas;
                    try {
                        estimadas = r.totalHorasEstimadas();
                        realizadas = r.totalHorasRealizadas();
                    } catch (Exception e) {
                        estimadas = 0L;
                        realizadas = 0L;
                    }

                    BigDecimal progresso = BigDecimal.ZERO;
                    if (estimadas != null && estimadas> 0 && realizadas != null) {
                        progresso = BigDecimal.valueOf(realizadas).multiply(BigDecimal.valueOf(100).divide(BigDecimal.valueOf(estimadas), 2,RoundingMode.HALF_UP));
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
                            resolveTempo.transformarToSexagesimal(estimadas),
                            resolveTempo.transformarToSexagesimal(realizadas),
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
                    Long estimadas;
                    Long realizadas;
                    try {
                        estimadas = r.totalHorasEstimadas();
                        realizadas = r.totalHorasRealizadas();
                    } catch (Exception e) {
                        estimadas = 0L;
                        realizadas = 0L;
                    }

                    BigDecimal progresso = BigDecimal.ZERO;
                    if (estimadas != null && estimadas> 0 && realizadas != null) {
                        progresso = BigDecimal.valueOf(realizadas).multiply(BigDecimal.valueOf(100).divide(BigDecimal.valueOf(estimadas), 2,RoundingMode.HALF_UP));
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
                            resolveTempo.transformarToSexagesimal(estimadas),
                            resolveTempo.transformarToSexagesimal(realizadas),
                            progresso
                    );
                })
                .toList();
    }

    public List<SprintListagemDTO> listarSprints() {
        return repository.listarSprints();
    }
}