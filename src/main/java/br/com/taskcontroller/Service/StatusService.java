package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Status.StatusTransicaoDTO;
import br.com.taskcontroller.Respository.StatusEntidadeRepository;
import br.com.taskcontroller.Respository.StatusTransicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusTransicaoRepository statusTransicaoRepository;

    @Autowired
    private StatusEntidadeRepository statusEntidadeRepository;

  public List<StatusTransicaoDTO> buscarProximosStatus(Long idStatus, Long idTipo_Entidade) {
      return statusTransicaoRepository.buscarProximoStatus(idStatus,idTipo_Entidade);
  }
    public StatusEntidades buscarPorId(Long idStatus) {
        return statusEntidadeRepository.findById(idStatus).orElseThrow(() -> new RuntimeException("Status não encontrado"));
    }

    public List<StatusEntidades> listarStatusEntidades() {
        List<StatusEntidades> statusEntidades = statusEntidadeRepository.findAll();
        return statusEntidades;
    }
    public Integer proximaOrdem(Long idTipoEntidade) {
        Integer maiorOrdem = statusEntidadeRepository.buscarMaiorOrdem(idTipoEntidade);

        return maiorOrdem + 1;
    }
    public StatusEntidades salvar(StatusEntidades statusEntidades) {
        if (statusEntidades.getIdstatus() == null) {
            statusEntidades.setOrdem(proximaOrdem(statusEntidades.getTipoentidade().getIdtipo_entidade()));
            statusEntidadeRepository.save(statusEntidades);
        }
        return statusEntidadeRepository.save(statusEntidades);
    }
}