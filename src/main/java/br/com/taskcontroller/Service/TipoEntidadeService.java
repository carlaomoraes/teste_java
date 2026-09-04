package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.TipoEntidade;
import br.com.taskcontroller.Record.Status.StatusEntidadesListagemDTO;
import br.com.taskcontroller.Record.Status.TipoEntidadeDTO;
import br.com.taskcontroller.Respository.TipoEntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEntidadeService {

    @Autowired
    private TipoEntidadeRepository repository;

    public TipoEntidade buscarPorId(Long idTipoEntidade) {
        return repository.findById(idTipoEntidade).orElseThrow(() -> new RuntimeException("Tipo de entidade não encontrado"));
    }

    public List<TipoEntidadeDTO> montaComboTipoEntidade() {
        return repository.montaComboTipoEntidade();
    }

    public List<StatusEntidadesListagemDTO> listar() {
        return repository.listar();
    }
}