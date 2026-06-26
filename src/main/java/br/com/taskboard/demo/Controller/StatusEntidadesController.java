package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.StatusEntidades;
import br.com.taskboard.demo.Respository.StatusEntidadesRepository;
import br.com.taskboard.demo.Service.StatusEntidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status_entidades")
public class StatusEntidadesController {

    @Autowired
    private StatusEntidadesService service;
    @Autowired
    private StatusEntidadesRepository tipoTarefaRepository;

    // LISTAR
    @GetMapping("/listar")
    public List<StatusEntidades> listar() {
        return service.listar();
    }

}