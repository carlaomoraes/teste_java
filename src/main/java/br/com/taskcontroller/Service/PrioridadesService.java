package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Prioridades;
import br.com.taskcontroller.Respository.PrioridadesRepository;
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
    public Prioridades buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Prioridade não encontrado."));
    }
}