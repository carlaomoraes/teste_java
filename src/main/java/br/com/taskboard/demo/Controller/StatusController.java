package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.Status;
import br.com.taskboard.demo.Respository.StatusRepository;
import br.com.taskboard.demo.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService service;
    @Autowired
    private StatusRepository statusRepository;

    // LISTAR
    @GetMapping("/listar")
    public List<Status> listar() {
        return service.listar();
    }

}