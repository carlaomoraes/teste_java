package br.com.taskcontroller.Service;


import br.com.taskcontroller.DTO.SprintEstoriaRequestDTO;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.COMBO.EmpreendimentoComboDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaBacklogDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaRoadmapDTO;
import br.com.taskcontroller.Respository.EmpreendimentoRepository;
import br.com.taskcontroller.Respository.EpicoEstoriasRepository;
import br.com.taskcontroller.Respository.SprintEstoriaRepository;
import br.com.taskcontroller.Respository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BacklogService {

    @Autowired
    private EpicoEstoriasRepository repository;

    @Autowired
    private EmpreendimentoRepository repositoryEmpreendimento;

    @Autowired
    private EstoriaService estoriaService;

    @Autowired
    private EpicoService epicoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SprintService sprintService;

    @Autowired
    private SprintEstoriaRepository sprintEstoriaRepository;

    @Autowired
    private SprintRepository sprintRepository;

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
        // 1. Busca a estória
        Estoria estoria = estoriaService.buscarPorId(dto.getIdestoria());
        estoria.setHoras_estimadas(dto.getHorasestimadas());
        estoria.setPontos(dto.getPontos());

        Usuario usuario = new Usuario();
        usuario.setIdusuario(dto.getIdresponsavel());
        estoria.setResponsavel(usuario);

        estoriaService.atualizar(estoria);

        // 2. Atualiza o épico
        Epico epico = epicoService.buscarPorId(dto.getIdepico());
        Prioridades prioridade = new Prioridades();
        prioridade.setIdprioridade(dto.getIdprioridade());
        epico.setPrioridade(prioridade);
        epico.setResponsavel(usuario);
        epicoService.atualizar(epico);

        // 3. Cria o vínculo da estória com a sprint
        Sprint sprint = sprintService.buscarPorId(dto.getIdsprint());
        SprintEstoria sprintEstoria = new SprintEstoria();
        sprintEstoria.setDataplanejamento(dto.getDataplanejamento());
        sprintEstoria.setEstoria(estoria);
        sprintEstoria.setSprint(sprint);

        return sprintEstoriaRepository.save(sprintEstoria);
    }
}