package br.com.taskcontroller.Service;


import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.Epico;
import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Record.COMBO.EstoriaComboDTO;
import br.com.taskcontroller.Respository.EstoriaRepository;
import br.com.taskcontroller.Respository.StatusEntidadesRepository;
import br.com.taskcontroller.Respository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EstoriaService {

    @Autowired
    private EstoriaRepository estoriaRepository;

    @Autowired
    private EpicoService epicoService;

    @Autowired
    private StatusEntidadesRepository statusEntidadesRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    public Estoria salvar(Estoria estoria) {
        Epico epico = epicoService.buscarPorId(estoria.getEpico().getIdepico());

        BigDecimal horas_realizadas = BigDecimal.ZERO;

        alterarStatus(estoria.getIdestoria(), estoria.getStatus().getIdstatus());
        estoria.setEpico(epico);
        estoria.setHoras_realizadas(horas_realizadas);

        epicoService.atualizarPercentual(estoria.getEpico().getIdepico());

        return estoriaRepository.save(estoria);

    }

    public List<EstoriaComboDTO> listar() {

        return estoriaRepository.listar();
    }

    public Estoria atualizar(Estoria Estoria) {
        alterarStatus(Estoria.getIdestoria(), Estoria.getStatus().getIdstatus());
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
    public void alterarStatus(Long idEstoria, Long idStatus) {
        Estoria estoria = estoriaRepository.findById(idEstoria)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Estória não encontrada"));

        StatusEntidades status = statusEntidadesRepository.findById(idStatus)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Status não encontrado"));

        estoria.setStatus(status);
        estoriaRepository.save(estoria);

        epicoService.atualizarPercentual(estoria.getEpico().getIdepico());
    }

}