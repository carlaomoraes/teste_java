package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.Prioridades;
import br.com.taskboard.demo.Respository.PrioridadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrioridadesService {

    @Autowired
    private PrioridadesRepository repository;

    public List<Prioridades> listar() {
        return repository.findAll();
    }

}