package br.com.taskcontroller.Service;


import br.com.taskcontroller.Utilidades.ResolveTempo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO;
import br.com.taskcontroller.Respository.RelatoriosSprintRepository;

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

                    Long progresso = 0L;

                    if (estimadas != null &&
                            estimadas> 0 &&
                            realizadas != null) {

                        progresso = (realizadas * 100 / estimadas);
                    }

                    return new RelatorioSprintDTO(
                            r.idempreendimento(),
                            r.descempreendimento(),
                            r.descsprint(),
                            r.dtiniciosprint(),
                            r.dtfinalsprint(),
                            r.descstatus(),
                            r.contEstorias(),
                            r.contTarefas(),
                            r.totalHorasEstimadas(),
                            r.totalHorasRealizadas(),
                            resolveTempo.transformarToSexagesimal(r.totalHorasEstimadas()),
                            resolveTempo.transformarToSexagesimal(r.totalHorasRealizadas()),
                            progresso
                    );
                })
                .toList();
    }
}