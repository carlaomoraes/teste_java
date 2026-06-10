package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.Sprint;
import br.com.taskboard.demo.Respository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {

    @Autowired
    private SprintRepository repository;

    public Sprint salvar(Sprint Sprint) {

        return repository.save(Sprint);
    }

    public List<Sprint> listar() {

        return repository.findAll();
    }

    public Sprint atualizar(Sprint Sprint) {

        return repository.save(Sprint);
    }


    public void excluir(Long idSprint) {
        repository.deleteById(idSprint);
    }

    public Sprint buscarPorId(Long idSprint) {
        return repository.findById(idSprint).orElseThrow(() -> new RuntimeException("Sprint não encontrado"));
    }
}