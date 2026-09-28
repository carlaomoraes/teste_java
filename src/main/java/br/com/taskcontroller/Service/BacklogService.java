package br.com.taskcontroller.Service;


import br.com.taskcontroller.DTO.SprintEstoriaRequestDTO;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.COMBO.EmpreendimentoComboDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaBacklogDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaRoadmapDTO;
import br.com.taskcontroller.Record.RoadmapOrdemDTO;
import br.com.taskcontroller.Respository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BacklogService {

    final private EpicoEstoriasRepository repository;
    final private EmpreendimentoRepository repositoryEmpreendimento;
    final private EstoriaService estoriaService;
    final private EpicoService epicoService;
    final private SprintService sprintService;
    final private PrioridadesService prioridadesService;
    final private SprintEstoriaRepository sprintEstoriaRepository;
    final private UsuarioService usuarioService;

    public BacklogService(
            EpicoEstoriasRepository repository,
            EmpreendimentoRepository repositoryEmpreendimento,
            EstoriaService estoriaService,
            EpicoService epicoService,
            SprintService sprintService,
            PrioridadesService prioridadesService,
            SprintEstoriaRepository sprintEstoriaRepository,
            UsuarioService usuarioService
    ) {
        this.repository = repository;
        this.repositoryEmpreendimento = repositoryEmpreendimento;
        this.estoriaService = estoriaService;
        this.epicoService = epicoService;
        this.sprintService = sprintService;
        this.prioridadesService = prioridadesService;
        this.sprintEstoriaRepository = sprintEstoriaRepository;
        this.usuarioService = usuarioService;
    }


    public List<EstoriaBacklogDTO> listar(Long idempreendimento) {
        return repository.listaEstoriasBacklog(idempreendimento);
    }

    public List<EmpreendimentoComboDTO> montaComboEmpreendimento() {
        return repositoryEmpreendimento.montaComboEmpreendimento();
    }

    public List<EstoriaRoadmapDTO> montaRoadmap(Long idempreendimento) {
        return repository.listaEstoriasRoadmap(idempreendimento);
    }
    @Transactional
    public SprintEstoria atualizar(SprintEstoriaRequestDTO dto) {
        // 1. Atualiza a estória
        Estoria estoria = estoriaService.buscarPorId(dto.getIdestoria());

        estoria.setHoras_estimadas(dto.getHorasestimadas());
        estoria.setPontos(dto.getPontos());

        Usuario usuario = usuarioService.buscarPorId(dto.getIdresponsavel());
        estoria.setResponsavel(usuario);
        estoriaService.atualizar(estoria);

        // 2. Atualiza o épico
        Epico epico = epicoService.buscarPorId(dto.getIdepico());

        Prioridades prioridade = prioridadesService.buscarPorId(dto.getIdprioridade());

        epico.setPrioridade(prioridade);
        epico.setResponsavel(usuario);

        epicoService.atualizar(epico);

        // 3. Vincula a estória à sprint
        Sprint sprint = sprintService.buscarPorId(dto.getIdsprint());

        SprintEstoria sprintEstoria = new SprintEstoria();

        sprintEstoria.setDataplanejamento(dto.getDataplanejamento());
        sprintEstoria.setEstoria(estoria);
        sprintEstoria.setSprint(sprint);
        sprintEstoria.setOrdem(sprintService.retornaOrdem(sprint.getIdsprint()));

        return sprintEstoriaRepository.save(sprintEstoria);
    }

    @Transactional
    public void reordenar(List<RoadmapOrdemDTO> lista) {
        for (RoadmapOrdemDTO dto : lista) {
            SprintEstoria sprintEstoria = sprintEstoriaRepository.buscarSprintEstoria(dto.idsprint(),dto.idestoria());
            sprintEstoria.setOrdem(dto.ordem());
        }
    }
}