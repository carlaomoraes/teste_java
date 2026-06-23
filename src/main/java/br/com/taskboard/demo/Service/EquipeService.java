package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Excecoes.ViolacaoChavaPrimariaException;
import br.com.taskboard.demo.Modelo.Equipe;
import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.EquipeRepository;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository repository;

    public Equipe salvar(Equipe equipe) {
        String Messagem = String.format("ID %s deve ser único.", equipe.getIdequipe());
        try {
            repository.save(equipe);
        } catch (StaleObjectStateException e) {
            throw new ViolacaoChavaPrimariaException(Messagem);
        }
        return equipe;
    }

    public List<Equipe> listar() {

        return repository.findAll();
    }

    public Equipe atualizar(Equipe Equipe) {

        return repository.save(Equipe);
    }
    public void excluir(Long idEquipe) {
        repository.deleteById(idEquipe);
    }

    public Equipe buscarPorId(Long idEquipe) {
        return repository.findById(idEquipe).orElseThrow(() -> new RuntimeException("Equipe não encontrada"));
    }

}