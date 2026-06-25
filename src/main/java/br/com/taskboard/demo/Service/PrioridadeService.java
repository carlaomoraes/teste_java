package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.Prioridade;
import br.com.taskboard.demo.Respository.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrioridadeService {

    @Autowired
    private PrioridadeRepository repository;

    public List<Prioridade> listar() {
        return repository.findAll();
    }

}