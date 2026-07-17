package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Papel;
import br.com.taskcontroller.Respository.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PapelService {

    @Autowired
    private PapelRepository repository;

    public Papel salvar(Papel Papel) {
         return repository.save(Papel);
    }

    public List<Papel> listar() {

        return repository.findAll();
    }

    public Papel atualizar(Papel Papel) {

        return repository.save(Papel);
    }

    public void excluir(Long idPapel) {
        repository.deleteById(idPapel);
    }

    public Papel buscarPorId(Long idPapel) {
        return repository.findById(idPapel).orElseThrow(() -> new RuntimeException("Papel não encontrado"));
    }
}