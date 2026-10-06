package br.com.taskcontroller.Service;


import br.com.taskcontroller.Excecoes.BusinessRuleException;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.StatusTransicao;
import br.com.taskcontroller.Record.Status.StatusTransicaoListagemDTO;
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

    public List<StatusTransicaoListagemDTO> listarWorkFlow(Long idTipoEntidade) {
        return repository.listarWorkflow(idTipoEntidade);
    }

    public void validarTransicao(StatusEntidades origem,
                                 StatusEntidades destino) {

        boolean permitida = repository.existsByStatusOrigemIdstatusAndStatusDestinoIdstatus(
                                origem.getIdstatus(),
                                destino.getIdstatus()
                        );

        if (!permitida) {
            throw new BusinessRuleException(
                    "Transição de status não permitida: "
                            + origem.getDescstatus()
                            + " → "
                            + destino.getDescstatus()
            );
        }
    }
}