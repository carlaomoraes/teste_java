package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Modelo.TipoAusencia;
import br.com.taskcontroller.Respository.TipoAusenciaRepository;
import br.com.taskcontroller.Service.TipoAusenciaService;
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