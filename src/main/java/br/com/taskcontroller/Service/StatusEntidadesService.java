package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Record.Status.StatusEntidadesListagemDTO;
import br.com.taskcontroller.Record.Status.TipoEntidadeDTO;
import br.com.taskcontroller.Respository.StatusEntidadeRepository;
import br.com.taskcontroller.Respository.TipoEntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusEntidadesService {

    @Autowired
    private StatusEntidadeRepository repository;

    @Autowired
    private TipoEntidadeRepository tipoEntidadeRepository;

    public StatusEntidades salvar(StatusEntidades StatusEntidades) {
        return repository.save(StatusEntidades);
    }

    public List<StatusEntidadesListagemDTO> listar() {
        //return repository.
        return null;
    }

    public StatusEntidades atualizar(StatusEntidades StatusEntidade) {
        return repository.save(StatusEntidade);
    }

    public void excluir(Long idStatusEntidade) {
        repository.deleteById(idStatusEntidade);
    }

    public StatusEntidades buscarPorId(Long idStatusEntidades) {
        return repository.findById(idStatusEntidades).orElseThrow(() -> new RuntimeException("Status Entidades não encontrado"));

    }

    public List<TipoEntidadeDTO> montaComboTipoEntidade() {
        return tipoEntidadeRepository.montaComboTipoEntidade();
    }

}