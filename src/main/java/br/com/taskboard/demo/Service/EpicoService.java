package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Excecoes.ViolacaoChaveEstrangeiraException;
import br.com.taskboard.demo.Modelo.Epico;
import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.EpicoRepository;
import br.com.taskboard.demo.Respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpicoService {

    @Autowired
    private EpicoRepository repository;

    public Epico salvar(Epico epico) {

        return repository.save(epico);
    }

    public List<Epico> listar() {

        return repository.findAll();
    }

    public Epico atualizar(Epico epico) {

        return repository.save(epico);
    }


    public void excluir(Long idepico) {
        try {
            repository.deleteById(idepico);
        } catch (DataIntegrityViolationException e) {
            throw new ViolacaoChaveEstrangeiraException("Não é possível excluir este registro pois ele está vinculado a outros dados no sistema.");
        }
    }

    public Epico buscarPorId(Long idepico) {
        return repository.findById(idepico).orElseThrow(() -> new RuntimeException("Épico não encontrado"));
    }
}
