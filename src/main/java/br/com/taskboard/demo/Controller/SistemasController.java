package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Sistema;
import br.com.taskboard.demo.Respository.SistemaRepository;
import br.com.taskboard.demo.Service.SistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sistemas")
public class SistemasController {

    @Autowired
    private SistemaService service;
    @Autowired
    private SistemaRepository sistemasRepository;

    // LISTAR
    @GetMapping("/listar")
    public List<Sistema> listar() {
        return service.listar();
    }

}