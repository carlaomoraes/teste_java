package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Epico;
import br.com.taskcontroller.Record.Epico.EpicoListagemDTO;
import br.com.taskcontroller.Record.EstoriaListagemDTO;
import br.com.taskcontroller.Respository.EpicoEstoriasRepository;
import br.com.taskcontroller.Respository.EpicoRepository;
import br.com.taskcontroller.Respository.EquipeEmpreendimentoRepository;
import br.com.taskcontroller.Respository.EstoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpicoService {

    @Autowired
    private EstoriaRepository estoriaRepository;

    @Autowired
    private EpicoEstoriasRepository relacionamentoRepository;

    @Autowired
    private EquipeEmpreendimentoRepository equipeEmpreendimentoRepository;

    @Autowired
    private EpicoRepository repository;

    public Epico salvar(Epico Epico) {
         return repository.save(Epico);
    }

    public List<EpicoListagemDTO> listar() {

        return repository.listar();
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
    public List<EstoriaListagemDTO> buscarEstoriaPorEpico(@Param("idepico") Long idepico) {
        return relacionamentoRepository.listaEstoriasPorEpico(idepico);
    }

}