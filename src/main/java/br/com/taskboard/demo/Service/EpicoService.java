package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.Epico;
import br.com.taskboard.demo.Modelo.Estoria;
import br.com.taskboard.demo.Respository.EpicoEstoriasRepository;
import br.com.taskboard.demo.Respository.EpicoRepository;
import br.com.taskboard.demo.Respository.EquipeEmpreendimentoRepository;
import br.com.taskboard.demo.Respository.StatusEntidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpicoService {

    @Autowired
    private EpicoRepository repository;

    @Autowired
    private EpicoEstoriasRepository  relacionamentoRepository;

    @Autowired
    private EquipeEmpreendimentoRepository equipeEmpreendimentoRepository;

    public Epico salvar(Epico Epico) {
         return repository.save(Epico);
    }

    public List<Epico> listar() {

        return repository.findAll();
    }

    public Epico atualizar(Epico Epico) {

        return repository.save(Epico);
    }
    public void excluir(Long idEpico) {
        repository.deleteById(idEpico);
    }

    public Epico buscarPorId(Long idEpico) {
        return repository.findById(idEpico).orElseThrow(() -> new RuntimeException("Épico não encontrado"));
    }
    public List<Estoria> buscarEstoriaPorEpico(@Param("idepico") Long idepico) {
        return relacionamentoRepository.buscarEstoriaPorEpico(idepico);
    }

}