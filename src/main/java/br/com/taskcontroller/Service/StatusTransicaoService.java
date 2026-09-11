package br.com.taskcontroller.Service;


import br.com.taskcontroller.Modelo.StatusTransicao;
import br.com.taskcontroller.Record.Status.StatusTransicaoDTO;
import br.com.taskcontroller.Record.Status.TipoEntidadeDTO;
import br.com.taskcontroller.Respository.StatusTransicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusTransicaoService {

    @Autowired
    private StatusTransicaoRepository repository;

    public StatusTransicao salvar(StatusTransicao statusTransicao) {
        return repository.save(statusTransicao);
    }

    public StatusTransicao atualizar(StatusTransicao statusTransicao) {
        return repository.save(statusTransicao);
    }

    public void excluir(Long idStatusTransicao) {
        repository.deleteById(idStatusTransicao);
    }

    public StatusTransicao buscarPorId(Long idStatusTransicao) {
        return repository.findById(idStatusTransicao).orElseThrow(() -> new RuntimeException("Status Transição não encontrado"));
    }

    public List<StatusTransicaoDTO> montaTransicao(Long idEmpreendimento,
                                                   Long idTipoEntidade) {
        return repository.montaTransicao(idEmpreendimento, idTipoEntidade);
    }

    public List<StatusTransicaoDTO> mostraProximosStatus(Long idEmpreendimento,
                                                  Long idTipoEntidade,
                                                  Long idStatus) {
        return repository.buscarStatusDisponiveis(idEmpreendimento, idTipoEntidade, idStatus);
    }


}