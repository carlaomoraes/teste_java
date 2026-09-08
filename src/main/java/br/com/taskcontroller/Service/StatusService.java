package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.*;
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

  public List<StatusEntidades> buscarProximosStatus(Long idStatus, Long idTipo_Entidade,  Long idEmpreendimento) {
      return statusTransicaoRepository
              .findByStatusOrigemIdstatusOrderByStatusDestinoOrdem(idStatus, idTipo_Entidade, idEmpreendimento)
              .stream()
              .map(StatusTransicao::getStatusDestino)
              .toList();
  }
    public StatusEntidades buscarPorId(Long idStatus) {
        return statusEntidadeRepository.findById(idStatus).orElseThrow(() -> new RuntimeException("Status não encontrado"));
    }

    public List<StatusEntidades> listarStatusEntidades() {
        List<StatusEntidades> statusEntidades = statusEntidadeRepository.findAll();
        return statusEntidades;
    }
    public Integer proximaOrdem(Long idEmpreendimento, Long idTipoEntidade) {
        Integer maiorOrdem = statusEntidadeRepository.buscarMaiorOrdem(
                idEmpreendimento,
                idTipoEntidade, 1);

        return maiorOrdem + 1;
    }
    public StatusEntidades salvar(StatusEntidades statusEntidades) {
        if (statusEntidades.getIdstatus() == null) {
            Integer ordem = proximaOrdem(statusEntidades.getEmpreendimento().getIdempreendimento(),
                                         statusEntidades.getTipoentidade().getIdtipo_entidade());
            statusEntidades.setOrdem(ordem);
            statusEntidadeRepository.save(statusEntidades);
        }
        return statusEntidadeRepository.save(statusEntidades);
    }
}