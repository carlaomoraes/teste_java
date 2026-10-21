package br.com.taskcontroller.Service;

import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.Tarefa;
import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Record.Tarefa.TarefaConsultaDTO;
import br.com.taskcontroller.Respository.StatusEntidadesRepository;
import br.com.taskcontroller.Respository.TarefaRepository;
import br.com.taskcontroller.Respository.UsuarioRepository;
import br.com.taskcontroller.Utilidades.ResolveTempo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private StatusEntidadesService statusEntidadesService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private StatusTransicaoService  statusTransicaoService;


    @Transactional
    public Tarefa salvar(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public List<TarefaConsultaDTO> listar(Long idEstoria) {

        return repository.buscarTarefaPorEstoria(idEstoria);
    }

    public Tarefa atualizar(Tarefa tarefa) {
        alterarStatus(tarefa.getIdtarefa(), tarefa.getStatus().getIdstatus());
        return repository.save(tarefa);
    }

    public void excluir(Long idTarefa) {
        repository.deleteById(idTarefa);
    }

    public Tarefa buscarPorId(Long idTarefa) {
        return repository.findById(idTarefa).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public List<TarefaConsultaDTO> listarPorEstoria(Long idEstoria) {
        return repository.buscarTarefaPorEstoria(idEstoria);
    }

    public TarefaConsultaDTO buscaPorIDDTO(Long idTarefa) {
        return repository.buscarPorId(idTarefa);
    }

    @Transactional
    public void alterarStatus(Long idTarefa, Long idStatus) {

        Tarefa tarefa = repository.findById(idTarefa)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tarefa não encontrada"));

        StatusEntidades statusAtual = tarefa.getStatus();

        StatusEntidades novoStatus = statusEntidadesService.buscaStatusEntidades(idStatus);

        // Evita alteração desnecessária
        if (statusAtual.getIdstatus().equals(novoStatus.getIdstatus())) {
            return;
        }

        // Valida a transição cadastrada no workflow
        statusTransicaoService.validarTransicao(statusAtual, novoStatus);

        // Atualiza o status
        tarefa.setStatus(novoStatus);

        // Atualiza a data de conclusão
        if (novoStatus.isFinalizado()) {
            tarefa.setData_conclusao(LocalDate.now());
        } else {
            // Caso a tarefa seja reaberta
            tarefa.setData_conclusao(null);
        }

        repository.save(tarefa);
    }
    @Transactional
    public void alterarResponsavel(Long idTarefa, Long idUsuario) {
        Tarefa tarefa = repository.findById(idTarefa)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tarefa não encontrada"));

        Usuario responsavel = usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Usuário não encontrado"));

        tarefa.setResponsavel(responsavel);

        repository.save(tarefa);
    }
}