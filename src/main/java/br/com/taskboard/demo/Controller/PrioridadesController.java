package br.com.taskboard.demo.Controller;


import br.com.taskboard.demo.Modelo.Prioridades;
import br.com.taskboard.demo.Respository.PrioridadesRepository;
import br.com.taskboard.demo.Service.PrioridadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prioridade")
public class PrioridadesController {

    @Autowired
    private PrioridadesService service;
    @Autowired
    private PrioridadesRepository prioridadeRepository;

    // LISTAR
    @GetMapping("/listar")
    public List<Prioridades> listar() {
        return service.listar();
    }

}