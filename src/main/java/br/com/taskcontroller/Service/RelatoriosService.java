package br.com.taskcontroller.Service;

import br.com.taskcontroller.DTO.Relatorios.*;
import br.com.taskcontroller.Record.Sprint.SprintListagemDTO;
import br.com.taskcontroller.Utilidades.ResolveTempo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.taskcontroller.Record.Relatorios.RelatorioSprintDTO;
import br.com.taskcontroller.Respository.RelatoriosSprintRepository;

import java.util.List;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;


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

    public List<RelatorioHorasTarefaDTO> gerarRelatorioHorasDetalhado(@Param("idSprint") List<Long> idSprint) {
        ResolveTempo resolveTempo = new ResolveTempo();

        List<RelatorioHorasTarefaDTO> relatorios = repository.gerarRelatorioHorasDetalhado(idSprint);

        List<RelatorioHorasTarefaDTO> tarefas = relatorios.stream()
                .map(r -> {
                    return new RelatorioHorasTarefaDTO(
                            r.idsprint(),
                            r.descsprint(),
                            r.idepico(),
                            r.descepico(),
                            r.idestoria(),
                            r.descestoria(),
                            r.idtarefa(),
                            r.desctarefa(),
                            r.responsavel(),
                            r.descstatus(),
                            r.totalHorasEstimadas(),
                            r.totalHorasRealizadas(),
                            resolveTempo.transformarToSexagesimal(r.totalHorasEstimadas()),
                            resolveTempo.transformarToSexagesimal(r.totalHorasRealizadas()),
                            r.Saldo(),
                            resolveTempo.transformarToSexagesimal(r.totalHorasEstimadas() - r.totalHorasRealizadas()),
                            r.totalizacaoTarefa()
                            );
                })
                .toList();
        // TOTALIZAÇÃO PARA TESTE
        RelatorioTotalHorasDTO total = totalizarHoras(tarefas);

        List<RelatorioHorasEstoriasDTO> estorias = agruparPorEstoria(tarefas);

        estorias.forEach(estoria -> {
            System.out.println("Estória: " + estoria.getIdestoria());
            System.out.println("Total Horas Estimadas: " + total.getTotalHorasEstimadas60());
            System.out.println("Total Horas Realizadas: " + total.getTotalHorasRealizadas60());
            System.out.println("Quantidade de tarefas: " + estoria.getTarefas().size());
        });

        List<RelatorioHorasEpicoDTO> epicos = agruparPorEpico(tarefas);


        epicos.forEach(epico -> {
            System.out.println("----------------------------------------------");

            System.out.println("Épico: " + epico.getDescepico());

            System.out.println("Total Horas Estimadas: " + epico.getTotal().getTotalHorasEstimadas60());

            System.out.println("Total Horas Realizadas: " + epico.getTotal().getTotalHorasRealizadas60());

            System.out.println("Quantidade de Estórias: " + epico.getEstorias().size());

        });

        List<RelatorioHorasSprintDTO> sprints = agruparPorSprint(tarefas);

        sprints.forEach(sprint -> {

            System.out.println("--------------------------");

            System.out.println("Sprint: " + sprint.getIdsprint());

            System.out.println("Total Horas Estimadas: " + sprint.getTotal().getTotalHorasEstimadas60());

            System.out.println("Total Horas Realizadas: "+ sprint.getTotal().getTotalHorasRealizadas60());

            System.out.println("Saldo: "+ sprint.getTotal().getSaldo60());

            System.out.println("Quantidade de Épicos: "+ sprint.getEpicos().size());


        });
        return tarefas;
    }
    private RelatorioTotalHorasDTO totalizarHoras(List<RelatorioHorasTarefaDTO> tarefas) {
        ResolveTempo resolveTempo = new ResolveTempo();

        BigDecimal estimadas = tarefas.stream()
                .map(RelatorioHorasTarefaDTO::totalHorasEstimadas)
                .map(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal realizadas = tarefas.stream()
                .map(RelatorioHorasTarefaDTO::totalHorasRealizadas)
                .map(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal saldo = estimadas.subtract(realizadas);

        RelatorioTotalHorasDTO total = new RelatorioTotalHorasDTO();

        total.setTotalHorasEstimadas(estimadas);
        total.setTotalHorasRealizadas(realizadas);
        total.setSaldo(saldo);

        total.setTotalHorasEstimadas60(resolveTempo.transformarToSexagesimal(estimadas.longValue()));

        total.setTotalHorasRealizadas60(resolveTempo.transformarToSexagesimal(realizadas.longValue()));

        total.setSaldo60(resolveTempo.transformarToSexagesimal(saldo.longValue()));

        total.setTotalTarefas((long) tarefas.size());

        total.setTotalEpicos(tarefas.stream()
                .map(RelatorioHorasTarefaDTO::idepico)
                .distinct()
                .count()
        );

        total.setTotalEstorias(
                tarefas.stream()
                        .map(RelatorioHorasTarefaDTO::idestoria)
                        .distinct()
                        .count()
        );

        total.setTotalTarefas(
                tarefas.stream()
                        .map(RelatorioHorasTarefaDTO::idtarefa)
                        .distinct()
                        .count()
        );
        return total;
    }

    private List<RelatorioHorasEstoriasDTO> agruparPorEstoria(
            List<RelatorioHorasTarefaDTO> tarefas) {

        return tarefas.stream()
                .collect(Collectors.groupingBy(
                        RelatorioHorasTarefaDTO::idestoria,
                        LinkedHashMap::new,
                        Collectors.toList()
                ))
                .values()
                .stream()
                .map(lista -> new RelatorioHorasEstoriasDTO(
                        lista.get(0).idtarefa(),
                        lista.get(0).idestoria(),
                        lista.get(0).descestoria(),
                        lista.get(0).idepico(),
                        lista.get(0).descepico(),
                        lista.get(0).totalHorasEstimadas(),
                        lista.get(0).totalHorasRealizadas(),
                        BigDecimal.ZERO,
                        BigDecimal.ZERO,
                        lista))
                .toList();
    }
    private List<RelatorioHorasEpicoDTO> agruparPorEpico(
            List<RelatorioHorasTarefaDTO> tarefas) {

        return tarefas.stream()
                .collect(Collectors.groupingBy(
                        RelatorioHorasTarefaDTO::idepico,
                        LinkedHashMap::new,
                        Collectors.toList()
                ))
                .values()
                .stream()
                .map(lista -> new RelatorioHorasEpicoDTO(
                        lista.get(0).idepico(),
                        lista.get(0).descepico(),
                        totalizarHoras(lista),
                        agruparPorEstoria(lista)
                ))
                .toList();
    }

    private List<RelatorioHorasSprintDTO> agruparPorSprint(
            List<RelatorioHorasTarefaDTO> tarefas) {

        return tarefas.stream()
                .collect(Collectors.groupingBy(
                        RelatorioHorasTarefaDTO::idsprint,
                        LinkedHashMap::new,
                        Collectors.toList()
                ))
                .values()
                .stream()
                .map(lista -> new RelatorioHorasSprintDTO(
                        lista.get(0).idsprint(),
                        lista.get(0).descsprint(),
                        totalizarHoras(lista),
                        agruparPorEpico(lista)
                ))
                .toList();
    }

    public RelatorioHorasConsolidadoDTO gerarRelatorioHorasConsolidado(
            List<Long> idSprint) {
        return new RelatorioHorasConsolidadoDTO(totalizarHoras(gerarRelatorioHorasDetalhado(idSprint)));
    }
}