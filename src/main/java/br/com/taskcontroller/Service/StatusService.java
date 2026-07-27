package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.AusenciaProgramada;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.StatusTransicao;
import br.com.taskcontroller.Respository.AusenciaProgramadaRepository;
import br.com.taskcontroller.Respository.StatusEntidadeRepository;
import br.com.taskcontroller.Respository.StatusTransicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusTransicaoRepository statusTransicaoRepository;

    public List<StatusEntidades> buscarProximosStatus(Long idStatus) {
        return statusTransicaoRepository
                .findByStatusOrigemIdstatusOrderByStatusDestinoOrdem(idStatus)
                .stream()
                .map(StatusTransicao::getStatusDestino)
                .toList();
    }
}