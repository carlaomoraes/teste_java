package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Mapper.EpicoMapper;
import br.com.taskcontroller.Mapper.EstoriaMapper;
import br.com.taskcontroller.Mapper.TarefaMapper;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Epico.EpicoConsultaDTO;
import br.com.taskcontroller.Record.Epico.EpicoInclusaoDTO;
import br.com.taskcontroller.Record.Epico.EpicoListagemDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaConsultaDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaInclusaoDTO;
import br.com.taskcontroller.Record.Tarefa.TarefaInclusaoDTO;
import br.com.taskcontroller.Respository.*;
import br.com.taskcontroller.Service.EpicoService;
import br.com.taskcontroller.Service.PrioridadesService;
import br.com.taskcontroller.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epicos")
public class EpicoController {

    @Autowired
    private EpicoService service;

    @Autowired
    private EpicoEstoriasRepository epicoEstoriasRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EpicoRepository epicoRepository;
    @Autowired
    private PrioridadesRepository prioridadesRepository;
    @Autowired
    private StatusEntidadesRepository statusEntidadesRepository;


    @Autowired
    private EmpreendimentoRepository empreendimentoRepository;


    // BUSCAR POR ID - DTO
    @GetMapping("/DTO/{idepico}")
    public ResponseEntity<EpicoConsultaDTO> buscarPorId(@PathVariable Long idepico) {
        try {
            EpicoConsultaDTO epico = epicoRepository.buscaPorID(idepico);
            return ResponseEntity.ok().body(epico);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public ResponseEntity<Epico> salvar(@RequestBody EpicoInclusaoDTO dto) {
        Epico epico;
        if(dto.idepico() == null){
            epico = EpicoMapper.toEntity(dto);
        } else {
            epico = service.buscarPorId(dto.idepico());
            epico.setBloqueado(dto.bloqueado());
            epico.setData_cadastro(dto.data_cadastro());
            epico.setData_inicio(dto.data_inicio());
            epico.setData_fim_prevista(dto.data_fim_prevista());
            epico.setCodepico(dto.codepico());
            epico.setCor(dto.cor());
            epico.setPercentual(dto.percentual());
            epico.setNome(dto.nome());
            epico.setCor(dto.cor());
            epico.setPercentual(dto.percentual());
            epico.setAtivo(dto.ativo());
            epico.setBloqueado(dto.bloqueado());
        }
        Empreendimento empreendimento = empreendimentoRepository.findById(dto.idempreendimento()).orElse(null);
        epico.setEmpreendimento(empreendimento);
        Usuario usuario = usuarioRepository.findById(dto.idresponsavel()).orElse(null);
        epico.setResponsavel(usuario);
        StatusEntidades status = statusEntidadesRepository.findById(dto.idstatus()).orElse(null);
        epico.setStatus(status);
        Prioridades prioridades = prioridadesRepository.findById(dto.idprioridade()).orElse(null);
        epico.setPrioridade(prioridades);
        return ResponseEntity.ok(service.salvar(epico));
    }

    // LISTAR
    @GetMapping("/listar")
    public List<EpicoListagemDTO> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idepico}")
    public ResponseEntity<String> excluir(@PathVariable Long idepico) {
        service.excluir(idepico);
        return ResponseEntity.ok().body("Épico excluído com sucesso");
    }
    // =========================
    // ESTORIAS POR ÉPICOS
    // =========================
    // BUSCAR POR ID
    // =========================
    @GetMapping("/{idepico}/estorias/{idestoria}")
    public ResponseEntity<?> buscarEstoriaPorId(@PathVariable Long idepico,
                                                @PathVariable Long idestoria) {
        Epico epico = service.buscarPorId(idepico);
        if (epico == null) {
            ResponseEntity.status(HttpStatus.CONFLICT).body("Épico não encontrado");
        }
        EstoriaConsultaDTO estoria = epicoEstoriasRepository.buscarPorId(idestoria);
        if (estoria == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Estória não encontrada");
        }
        return ResponseEntity.ok().body(estoria);
    }
    // LISTAR TODAS ESTÓRIAS POR ÉPICO
    @GetMapping("/{idEpico}/estorias")
    public List<EstoriaConsultaDTO> listarEstoriaPorEpico(@PathVariable Long idEpico) {
        return epicoEstoriasRepository.listaEstoriasPorEpico(idEpico);
    }

    @PostMapping("/{idEpico}/adicionarEstoria")
    public ResponseEntity<?> adicionarEstoria(
            @PathVariable Long idEpico,
            @RequestBody EstoriaInclusaoDTO dto) {
        Estoria estoria = EstoriaMapper.toEntity(dto);
        return ResponseEntity.ok(epicoEstoriasRepository.save(estoria));
    }

    // APAGAR UMA ESTORIA
    @DeleteMapping("/remover_estoria/{idEstoria}")
    public ResponseEntity<?> removerMembro(@PathVariable Long idEstoria) {
        epicoEstoriasRepository.apagarEstoria(idEstoria);
        return ResponseEntity.noContent().build();
    }

}