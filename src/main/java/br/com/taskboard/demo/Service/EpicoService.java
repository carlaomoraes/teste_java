package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.Epico;
import br.com.taskboard.demo.Modelo.Estoria;
import br.com.taskboard.demo.Respository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpicoService {

    @Autowired
    private EstoriaRepository estoriaRepository;

    @Autowired
    private EpicoEstoriasRepository  relacionamentoRepository;

    @Autowired
    private EquipeEmpreendimentoRepository equipeEmpreendimentoRepository;

    @Autowired
    private EpicoRepository repository;

    public Epico salvar(Epico Epico) {
         return repository.save(Epico);
    }

    public List<Epico> listar() {

        return repository.findByAtivoTrue();
    }

    public Epico atualizar(Epico Epico) {

        return repository.save(Epico);
    }
    public void excluir(Long idEpico) {
        Epico epico = repository.findById(idEpico)
                .orElseThrow(() -> new RuntimeException("Épico não encontrado!"));
        if(estoriaRepository.existsById(idEpico)) {
            throw new RuntimeException("Não é possivel inativar esse épico pois existem estórias");
        }
        epico.setAtivo(0);
        repository.save(epico);
    }

    public Epico buscarPorId(Long idEpico) {
        return repository.findById(idEpico).orElseThrow(() -> new RuntimeException("Épico não encontrado"));
    }
    public List<Estoria> buscarEstoriaPorEpico(@Param("idepico") Long idepico) {
        return relacionamentoRepository.buscarEstoriaPorEpico(idepico);
    }

}