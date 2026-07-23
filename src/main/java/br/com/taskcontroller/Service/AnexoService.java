package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Anexo;
import br.com.taskcontroller.Modelo.AusenciaProgramada;
import br.com.taskcontroller.Respository.AnexoRepository;
import br.com.taskcontroller.Respository.AusenciaProgramadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnexoService {

    @Autowired
    private AnexoRepository repository;


    public Anexo salvar(Anexo anexo) {
        return repository.save(anexo);
    }

    public void excluir(Long idAnexo) {
        repository.deleteById(idAnexo);
    }


    public List<Anexo> listarPorEpico(Long idEpico) {
        return repository.findByEpico_Idepico(idEpico);
    }
}