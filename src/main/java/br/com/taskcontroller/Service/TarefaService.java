package br.com.taskcontroller.Service;

import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Modelo.Tarefa;
import br.com.taskcontroller.Record.Tarefa.TarefaConsultaDTO;
import br.com.taskcontroller.Respository.EstoriaRepository;
import br.com.taskcontroller.Respository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Transactional
    public Tarefa salvar(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public List<TarefaConsultaDTO> listar(Long idEstoria) {

        return repository.buscarTarefaPorEstoria(idEstoria);
    }

    public Tarefa atualizar(Tarefa Tarefa) {

        return repository.save(Tarefa);
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
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));
//
//        StatusEntidades novoStatus = statusRepository.findById(idStatus)
//                .orElseThrow(() -> new ResourceNotFoundException("Status não encontrado"));
//
//        statusEntidadesService.validarTransicao(tarefa.getStatus(), novoStatus);
//        tarefa.setStatus(novoStatus);
        repository.save(tarefa);
    }

}