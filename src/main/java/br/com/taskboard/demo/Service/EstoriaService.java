package br.com.taskboard.demo.Service;


import br.com.taskboard.demo.Modelo.Epico;
import br.com.taskboard.demo.Modelo.Estoria;
import br.com.taskboard.demo.Respository.EstoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoriaService {

    @Autowired
    private EstoriaRepository repository;

    @Autowired
    private EpicoService epicoService;


    public Estoria salvar(Estoria estoria) {
        Epico epico = new Epico();
        epico = epicoService.buscarPorId(estoria.getEpico().getIdepico());
        estoria.setEpico(epico);
        return repository.save(estoria);
    }

    public List<Estoria> listar() {

        return repository.findAll();
    }

    public Estoria atualizar(Estoria Estoria) {

        return repository.save(Estoria);
    }


    public void excluir(Long idEstoria) {
        repository.deleteById(idEstoria);
    }

    public Estoria buscarPorId(Long idEstoria) {
        return repository.findById(idEstoria).orElseThrow(() -> new RuntimeException("Estória não encontrada"));
    }
}