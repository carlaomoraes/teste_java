package br.com.taskboard.demo.Service;


import br.com.taskboard.demo.Modelo.Epico;
import br.com.taskboard.demo.Modelo.Estoria;
import br.com.taskboard.demo.Respository.EstoriaRepository;
import br.com.taskboard.demo.Respository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoriaService {

    @Autowired
    private EstoriaRepository estoriaRepository;

    @Autowired
    private EpicoService epicoService;

    @Autowired
    private TarefaRepository tarefaRepository;


    public Estoria salvar(Estoria estoria) {
        Epico epico = new Epico();
        epico = epicoService.buscarPorId(estoria.getIdepico().getIdepico());
        estoria.setIdepico(epico);
        return estoriaRepository.save(estoria);
    }

    public List<Estoria> listar() {

        return estoriaRepository.findAll();
    }

    public Estoria atualizar(Estoria Estoria) {

        return estoriaRepository.save(Estoria);
    }

    public void excluir(Long idEstoria) {
        Estoria estoria = estoriaRepository.findById(idEstoria)
                .orElseThrow(() -> new RuntimeException("Estória não encontrada"));

        if (tarefaRepository.existsByEstoriaAndAtivaTrue(estoria)) {
            throw new RuntimeException(
                    "Não é possível inativar a estória porque existem tarefas ativas.");
        }

        estoria.setAtiva(0);

        estoriaRepository.save(estoria);
    }

    public Estoria buscarPorId(Long idEstoria) {
        return estoriaRepository.findById(idEstoria).orElseThrow(() -> new RuntimeException("Estória não encontrada"));
    }
}