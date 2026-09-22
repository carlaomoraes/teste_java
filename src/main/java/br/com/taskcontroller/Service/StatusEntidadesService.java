package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Record.Status.StatusDTO;
import br.com.taskcontroller.Record.Status.StatusEntidadesListagemDTO;
import br.com.taskcontroller.Record.Status.TipoEntidadeDTO;
import br.com.taskcontroller.Respository.StatusEntidadeRepository;
import br.com.taskcontroller.Respository.TipoEntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public StatusEntidades atualizar(StatusEntidades StatusEntidade) {
        return repository.save(StatusEntidade);
    }

    public void excluir(Long idStatusEntidade) {
        repository.deleteById(idStatusEntidade);
    }

    public StatusEntidades buscarPorId(Long idStatusEntidades) {
        return repository.findById(idStatusEntidades).orElseThrow(() -> new RuntimeException("Status Entidades não encontrado"));

    }
    public List<TipoEntidadeDTO> montaComboOrigem(Long  idTipoEntidade) {
        return repository.montaComboOrigem(idTipoEntidade);
    }
    public List<StatusDTO> mostraStatusDisponiveis(Long idTipoEntidade,
                                                   Long idStatusOrigem) {
        return repository.mostraStatusDisponiveis(idTipoEntidade,idStatusOrigem);
    }
    public List<StatusDTO> achaOrigem(Long idTipoEntidade) {
        return repository.achaOrigem(idTipoEntidade);
    }
}