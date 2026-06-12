package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.TipoTarefa;
import br.com.taskboard.demo.Respository.TipoTarefaRepository;
import br.com.taskboard.demo.Service.TipoTarefaService;
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