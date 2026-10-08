package br.com.taskcontroller.Service;


import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.Epico;
import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Record.COMBO.EstoriaComboDTO;
import br.com.taskcontroller.Respository.EstoriaRepository;
import br.com.taskcontroller.Respository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstoriaService {

    @Autowired
    private EstoriaRepository estoriaRepository;

    @Autowired
    private EpicoService epicoService;

    @Autowired
    private StatusEntidadesService statusEntidadesService;

    @Autowired
    private StatusTransicaoService statusTransicaoService;

    public Estoria salvar(Estoria estoria) {
        Epico epico = epicoService.buscarPorId(estoria.getEpico().getIdepico());

        alterarStatus(estoria.getIdestoria(), estoria.getStatus().getIdstatus());
        estoria.setEpico(epico);
        return estoriaRepository.save(estoria);
    }

    public List<EstoriaComboDTO> listar() {

        return estoriaRepository.listar();
    }

    public Estoria atualizar(Estoria Estoria) {

        return estoriaRepository.save(Estoria);
    }

    public void excluir(Long idEstoria) {
        Estoria estoria = estoriaRepository.findById(idEstoria)
                .orElseThrow(() -> new RuntimeException("Estória não encontrada"));

//        if (tarefaRepository.existsByEstoriaAndAtivaTrue(estoria)) {
//            throw new RuntimeException(
//                    "Não é possível inativar a estória porque existem tarefas ativas.");
//        }

        estoria.setAtiva(false);

        estoriaRepository.save(estoria);
    }

    public Estoria buscarPorId(Long idEstoria) {
        return estoriaRepository.findById(idEstoria).orElseThrow(() -> new RuntimeException("Estória não encontrada"));
    }

    @Transactional
    public void alterarStatus(Long id, Long idStatus) {
        Estoria estoria = estoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));

        StatusEntidades novoStatus = statusEntidadesService.buscaStatusEntidades(idStatus);

        estoria.setStatus(novoStatus);
    }
}