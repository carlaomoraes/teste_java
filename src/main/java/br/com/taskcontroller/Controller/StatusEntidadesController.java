package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Service.StatusEntidadesService;
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

    // LISTAR
    @GetMapping("/listar")
    public List<StatusEntidades> listar() {
        return service.listar();
    }

}