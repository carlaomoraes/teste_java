package br.com.taskcontroller.Service;

import br.com.taskcontroller.Excecoes.BusinessRuleException;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Respository.StatusEntidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusEntidadesService {

    @Autowired
    private StatusEntidadesRepository repository;

    public List<StatusEntidades> listar() {
        return repository.findAll();
    }

    public StatusEntidades buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Status de entidade não encontrado."));
    }
    void validarTransicao(StatusEntidades atual, StatusEntidades novo) {

        if (atual.getFinalizado() == 1) {
            throw new BusinessRuleException("Não é possível alterar uma tarefa concluída.");
        }

        if (atual.getCancelado() == 1) {
            throw new BusinessRuleException("Não é possível alterar uma tarefa cancelada.");
        }
        // Outras regras...

    }
    public List<StatusEntidades> buscaProximaStatus(Long idStatus) {
        return repository.buscarProximosStatus(idStatus);
    }
}