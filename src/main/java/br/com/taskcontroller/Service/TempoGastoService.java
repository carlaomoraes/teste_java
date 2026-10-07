package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.TempoGasto;
import br.com.taskcontroller.Record.TempoGasto.TempoGastoDTO;
import br.com.taskcontroller.Respository.TempoGastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempoGastoService {

    @Autowired
    private TempoGastoRepository repository;

    public TempoGasto salvar(TempoGasto TempoGasto) {
         return repository.save(TempoGasto);
    }

    public List<TempoGastoDTO> listar(@Param("idTarefa") Long idTarefa) {

        return repository.listarTempoGasto(idTarefa);
    }

    public TempoGasto atualizar(TempoGasto TempoGasto) {

        return repository.save(TempoGasto);
    }

    public void excluir(Long idTempoGasto) {

        repository.deleteById(idTempoGasto);
    }

    public TempoGasto buscarPorId(Long idTempoGasto) {
        return repository.findById(idTempoGasto).orElseThrow(() -> new RuntimeException("TempoGasto não encontrado"));
    }
}