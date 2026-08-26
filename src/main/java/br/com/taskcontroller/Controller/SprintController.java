package br.com.taskcontroller.Controller;

import br.com.taskcontroller.DTO.SprintEstoriaRequestDTO;
import br.com.taskcontroller.Excecoes.BusinessRuleException;
import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Ausencia.AusenciaListagemDTO;
import br.com.taskcontroller.Record.Sprint.SprintDataDTO;
import br.com.taskcontroller.Record.Sprint.SprintListagemDTO;
import br.com.taskcontroller.Respository.AusenciaProgramadaRepository;
import br.com.taskcontroller.Respository.SprintEstoriaRepository;
import br.com.taskcontroller.Respository.SprintRepository;
import br.com.taskcontroller.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sprints")
public class SprintController {

    @Autowired
    private SprintService service;

    @Autowired
    private EpicoService epicoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EstoriaService estoriaService;

    @Autowired
    private EmpreendimentoService empreendimentoService;

    @Autowired
    private AusenciaProgramadaRepository ausenciaProgramadaRepository;

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private SprintEstoriaRepository sprintEstoriaRepository;

    // BUSCAR POR ID
    @GetMapping("/{idSprint}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idSprint) {
        try {
            Sprint Sprint = service.buscarPorId(idSprint);
            return ResponseEntity.ok().body(Sprint);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Sprint não encontrada");
        }
    }
    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody Sprint sprint) {
        // 1. Valida se o Empreendimento existe
        Long idEmpreendimento = sprint.getEmpreendimento().getIdempreendimento();
        Empreendimento empreendimento = empreendimentoService.buscarPorId(idEmpreendimento);

        if (empreendimento == null) {
            throw new ResourceNotFoundException("Empreendimento não encontrado com ID: " + idEmpreendimento);
        }
        sprint.setEmpreendimento(empreendimento);

        // 2. Regra de Negócio: Trata/Valida Fim de Semana (Opcional, mas recomendado)
        if (isWeekend(sprint.getDtiniciosprint()) || isWeekend(sprint.getDtfinalsprint())) {
            throw new BusinessRuleException("A Sprint não pode iniciar ou terminar em um final de semana.");
        }

        // 3. Regra de Negócio: Checa Sobreposição no Banco
        int numSprint = sprintRepository.buscaSprintPorIntervalo(
                sprint.getDtiniciosprint(),
                sprint.getDtfinalsprint(),
                idEmpreendimento,
                sprint.getIdsprint()
        );

        if (numSprint > 0) {
            throw new BusinessRuleException("Já existe uma Sprint cadastrada para este empreendimento no período informado.");
        }

        // 4. Salva a Sprint
        return ResponseEntity.ok(sprintRepository.save(sprint));

    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idSprint}")
    public ResponseEntity<Sprint> atualizar(@PathVariable Long idSprint,
                             @RequestBody Sprint Sprint) {
        Sprint sprint = service.buscarPorId(idSprint);
        Empreendimento empreendimento = empreendimentoService.buscarPorId(sprint.getEmpreendimento().getIdempreendimento());
        if (empreendimento == null) {
            return ResponseEntity.notFound().build();
        }
        sprint.setEmpreendimento(empreendimento);

        Sprint.setIdsprint(idSprint);
        return ResponseEntity.ok().body(service.atualizar(Sprint));
    }

    // LISTAR
    @GetMapping("/listar/DTO/{idEmpreendimento}")
    public List<SprintListagemDTO> listar(@PathVariable Long idEmpreendimento) {
        return service.listar(idEmpreendimento);
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idSprint}")
    public ResponseEntity<String> excluir(@PathVariable Long idSprint) {
        String Messagem = String.format("Não é possível finalizar esta %s ");
        try {
            Sprint Sprint = service.buscarPorId(idSprint);
            Sprint.setDtfinalsprint(LocalDate.now());
            service.atualizar(Sprint);
            return ResponseEntity.ok().body("Sprint finalizada com sucesso!");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.ok().body(Messagem);
        }
    }
    // LISTAR AUSENCIA
    @GetMapping("/listar_ausencias")
    public List<AusenciaListagemDTO> listarAusencias(@RequestParam("data_inicio") LocalDate data_inicio,
                                                     @RequestParam("data_fim") LocalDate data_fim) {
        return ausenciaProgramadaRepository.buscarAusenciasDaSprint(data_inicio, data_fim);
    }
    // VEJA SPRINT SOBREPOSTA
    @GetMapping("/sprint_sobreposta")
    public boolean verificaSobreposta(
            @RequestParam LocalDate data_inicio,
            @RequestParam LocalDate data_fim,
            @RequestParam Long idempreendimento,
            @RequestParam(required = false) Long idsprint) {

        return service.existeSobreposicao(idempreendimento,idsprint,data_inicio,data_fim);
    }
    // RETORNA A ULTIMA SPRINT VALIDA DO EMPREENDIMENTO
    @GetMapping("/valida_ultima/{idempreendimento}")
    public Optional<SprintDataDTO> carregarValida(@PathVariable Long idempreendimento) {

        return service.carregarValida(idempreendimento);
    }

    private boolean isWeekend(LocalDate date) {
        if (date == null)
            return false;
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
    // Todas as funções da sprint atual
    // BUSCAR POR EMPREENDIMENTO
    @GetMapping("/monta_cabecalho")
    public ResponseEntity<?> montaCabecalho(@RequestParam LocalDate data_inicio,
                                          @RequestParam LocalDate data_fim,
                                          @RequestParam Long idempreendimento) {

        return ResponseEntity.ok(montaCabecalho(data_inicio,data_fim,idempreendimento));
    }
    @GetMapping("/carregaSprint/DTO/{idEmpreendimento}")
    public List<SprintDataDTO> carregarSprints(@PathVariable Long idEmpreendimento) {
        return sprintRepository.buscarSprintAtiva(idEmpreendimento);
    }

    @PostMapping("/atualiza_backlog")
    public ResponseEntity<?> atualiza_backlog(@RequestBody SprintEstoriaRequestDTO dto) {
        SprintEstoria sprintEstoria = new SprintEstoria();
        sprintEstoria.setDataplanejamento(dto.getDataplanejamento());
        Estoria estoria = estoriaService.buscarPorId(dto.getIdestoria());
        estoria.setHoras_estimadas(dto.getHorasestimadas());
        estoria.setPontos(dto.getPontos());;
        estoria.setHoras_estimadas(dto.getHorasestimadas());
        Usuario usuario = usuarioService.buscarPorId(dto.getIdresponsavel());
        estoria.setResponsavel(usuario);
        estoriaService.atualizar(estoria);
        Prioridades prioridades = new Prioridades();
        prioridades.setIdprioridade(dto.getIdprioridade());
        Epico epico = epicoService.buscarPorId(dto.getIdepico());
        epico.setPrioridade(prioridades);
        epico.setResponsavel(usuario);
        epicoService.atualizar(epico);
        sprintEstoria.setEstoria(estoria);
        Sprint sprint = service.buscarPorId(dto.getIdsprint());
        sprintEstoria.setSprint(sprint);
        return ResponseEntity.ok(sprintEstoriaRepository.save(sprintEstoria));
    }
    @DeleteMapping("/{idSprint}/{idEstoria}")
    public ResponseEntity<?> excluirDoRoadmap(@PathVariable Long idSprint,@PathVariable Long idEstoria) {
        service.excluirDoRoadmap(idSprint, idEstoria);
        return ResponseEntity.ok().build();
    }
}