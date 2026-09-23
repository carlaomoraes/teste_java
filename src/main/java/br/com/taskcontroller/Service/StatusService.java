package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Status.StatusTransicaoDTO;
import br.com.taskcontroller.Respository.StatusEntidadesRepository;
import br.com.taskcontroller.Respository.StatusTransicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusTransicaoRepository statusTransicaoRepository;

    @Autowired
    private StatusEntidadesRepository statusEntidadesRepository;

  public List<StatusTransicaoDTO> buscarProximosStatus(Long idStatus, Long idTipo_Entidade) {
      return statusTransicaoRepository.buscarProximoStatus(idStatus,idTipo_Entidade);
  }
    public StatusEntidades buscarPorId(Long idStatus) {
        return statusEntidadesRepository.findById(idStatus).orElseThrow(() -> new RuntimeException("Status não encontrado"));
    }

    public List<StatusEntidades> listarStatusEntidades() {
        List<StatusEntidades> statusEntidades = statusEntidadesRepository.findAll();
        return statusEntidades;
    }
    public Integer proximaOrdem(Long idTipoEntidade) {
        Integer maiorOrdem = statusEntidadesRepository.buscarMaiorOrdem(idTipoEntidade);

        return maiorOrdem + 1;
    }
    public StatusEntidades salvar(StatusEntidades statusEntidades) {
        if (statusEntidades.getIdstatus() == null) {
            statusEntidades.setOrdem(proximaOrdem(statusEntidades.getTipoentidade().getIdtipo_entidade()));
            statusEntidadesRepository.save(statusEntidades);
        }
        return statusEntidadesRepository.save(statusEntidades);
    }
}