package br.com.taskboard.demo.Controller;

import br.com.taskboard.demo.Modelo.TipoAusencia;
import br.com.taskboard.demo.Respository.TipoAusenciaRepository;
import br.com.taskboard.demo.Service.TipoAusenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo_ausencia")
public class TipoAusenciaController {

    @Autowired
    private TipoAusenciaService service;
    @Autowired
    private TipoAusenciaRepository TipoAusenciaRepository;

    // LISTAR
    @GetMapping("/listar")
    public List<TipoAusencia> listar() {
        return service.listar();
    }

}