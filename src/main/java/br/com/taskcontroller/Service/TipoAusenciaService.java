package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Tipo_Ausencia;
import br.com.taskcontroller.Respository.TipoAusenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAusenciaService {

    @Autowired
    private TipoAusenciaRepository repository;

    public List<Tipo_Ausencia> listar() {

        return repository.findAll();
    }

}