package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Tipo_Ausencia;
import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Record.Usuario.UsuarioListagemDTO;
import br.com.taskcontroller.Respository.TipoAusenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAusenciaService {

    @Autowired
    private TipoAusenciaRepository repository;

    public List<Tipo_Ausencia> listar() {

        return repository.findAll();
    }

    public Tipo_Ausencia salvar(Tipo_Ausencia tipo_ausencia) {

        return repository.save(tipo_ausencia);
    }

    public Tipo_Ausencia atualizar(Tipo_Ausencia tipo_ausencia) {

        return repository.save(tipo_ausencia);
    }

    public void excluir(Long id_tipo_ausencia) {
        repository.deleteById(id_tipo_ausencia);
    }

    public Tipo_Ausencia buscarPorId(Long id_tipo_ausencia) {
        return repository.findById(id_tipo_ausencia).orElseThrow(() -> new RuntimeException("Tipo de ausência não encontrado"));

    }

}