package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.Tarefa;
import br.com.taskboard.demo.Respository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public Tarefa salvar(Tarefa tarefa) {

        return repository.save(tarefa);
    }

    public List<Tarefa> listar() {

        return repository.findAll();
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
}