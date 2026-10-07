package br.com.taskcontroller.Service;

import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.Tarefa;
import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Record.Tarefa.TarefaConsultaDTO;
import br.com.taskcontroller.Respository.StatusEntidadesRepository;
import br.com.taskcontroller.Respository.TarefaRepository;
import br.com.taskcontroller.Respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private StatusEntidadesService statusEntidadesService;

    @Autowired
    private UsuarioRepository usuarioRepository;


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

        StatusEntidades novoStatus = statusEntidadesService.buscaStatusEntidades(idStatus);

        tarefa.setStatus(novoStatus);
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