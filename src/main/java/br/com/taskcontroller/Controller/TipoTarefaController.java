package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Modelo.TipoTarefa;
import br.com.taskcontroller.Respository.TipoTarefaRepository;
import br.com.taskcontroller.Service.TipoTarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_tarefa")
public class TipoTarefaController {

    @Autowired
    private TipoTarefaService service;
    @Autowired
    private TipoTarefaRepository tipoTarefaRepository;

    // LISTAR
    @GetMapping("/listar")
    public List<TipoTarefa> listar() {
        return service.listar();
    }

}