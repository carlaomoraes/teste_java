package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.TipoAusencia;
import br.com.taskboard.demo.Modelo.TipoTarefa;
import br.com.taskboard.demo.Respository.TipoAusenciaRepository;
import br.com.taskboard.demo.Respository.TipoTarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAusenciaService {

    @Autowired
    private TipoAusenciaRepository repository;

    public List<TipoAusencia> listar() {

        return repository.findAll();
    }

}