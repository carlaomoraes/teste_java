package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.TipoTarefa;
import br.com.taskboard.demo.Respository.TipoTarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTarefaService {

    @Autowired
    private TipoTarefaRepository repository;

    public TipoTarefa salvar(TipoTarefa TipoTarefa) {
         return repository.save(TipoTarefa);
    }

    public List<TipoTarefa> listar() {

        return repository.findAll();
    }

    public TipoTarefa atualizar(TipoTarefa TipoTarefa) {

        return repository.save(TipoTarefa);
    }

    public void excluir(Long idTipoTarefa) {
        repository.deleteById(idTipoTarefa);
    }

    public TipoTarefa buscarPorId(Long idTipoTarefa) {
        return repository.findById(idTipoTarefa).orElseThrow(() -> new RuntimeException("Tipo de tarefa não encontrado"));
    }
}