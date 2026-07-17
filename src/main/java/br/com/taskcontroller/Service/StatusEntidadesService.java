package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Respository.StatusEntidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusEntidadesService {

    @Autowired
    private StatusEntidadesRepository repository;

    public List<StatusEntidades> listar() {
        return repository.findAll();
    }

    public StatusEntidades buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Status de entidade não encontrado."));
    }


}