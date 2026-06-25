package br.com.taskboard.demo.Controller;


import br.com.taskboard.demo.Modelo.Prioridade;
import br.com.taskboard.demo.Respository.PrioridadeRepository;
import br.com.taskboard.demo.Service.PrioridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prioridade")
public class PrioridadeController {

    @Autowired
    private PrioridadeService service;
    @Autowired
    private PrioridadeRepository prioridadeRepository;

    // LISTAR
    @GetMapping("/listar")
    public List<Prioridade> listar() {
        return service.listar();
    }

}