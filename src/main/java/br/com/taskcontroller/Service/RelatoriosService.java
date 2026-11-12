package br.com.taskcontroller.Service;


import br.com.taskcontroller.Record.Sprint.SprintListagemDTO;
import br.com.taskcontroller.Utilidades.ResolveTempo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO;
import br.com.taskcontroller.Respository.RelatoriosSprintRepository;

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

                    Long estimadas = r.totalHorasEstimadas();
                    Long realizadas = r.totalHorasRealizadas();

                    long progresso = 0L;


                    if (estimadas != null &&
                            estimadas> 0 &&
                            realizadas != null) {

                        progresso = (realizadas * 100 / estimadas);
                    }

                    return new RelatorioSprintDTO(
                            r.idempreendimento(),
                            r.descempreendimento(),
                            r.idsprint(),
                            r.descsprint(),
                            r.dtiniciosprint(),
                            r.dtfinalsprint(),
                            r.descstatus(),
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

                    Long estimadas = r.totalHorasEstimadas();
                    Long realizadas = r.totalHorasRealizadas();

                    long progresso = 0L;


                    if (estimadas != null &&
                            estimadas> 0 &&
                            realizadas != null) {

                        progresso = (realizadas * 100 / estimadas);
                    }

                    return new RelatorioSprintDTO(
                            r.idempreendimento(),
                            r.descempreendimento(),
                            r.idsprint(),
                            r.descsprint(),
                            r.dtiniciosprint(),
                            r.dtfinalsprint(),
                            r.descstatus(),
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

                    Long estimadas = r.totalHorasEstimadas();
                    Long realizadas = r.totalHorasRealizadas();

                    long progresso = 0L;


                    if (estimadas != null &&
                            estimadas> 0 &&
                            realizadas != null) {

                        progresso = (realizadas * 100 / estimadas);
                    }

                    return new RelatorioSprintDTO(
                            r.idempreendimento(),
                            r.descempreendimento(),
                            r.idsprint(),
                            r.descsprint(),
                            r.dtiniciosprint(),
                            r.dtfinalsprint(),
                            r.descstatus(),
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