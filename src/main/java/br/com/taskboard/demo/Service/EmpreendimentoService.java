package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.Empreendimento;
import br.com.taskboard.demo.Respository.EmpreendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpreendimentoService {

    @Autowired
    private EmpreendimentoRepository repository;

    public Empreendimento salvar(Empreendimento Empreendimento) {

        return repository.save(Empreendimento);
    }

    public List<Empreendimento> listar() {

        return repository.findAll();
    }

    public Empreendimento atualizar(Empreendimento Empreendimento) {

        return repository.save(Empreendimento);
    }
    public void excluir(Long idEmpreendimento) {
        repository.deleteById(idEmpreendimento);
    }

    public Empreendimento buscarPorId(Long idEmpreendimento) {
        return repository.findById(idEmpreendimento).orElseThrow(() -> new RuntimeException("Épico não encontrado"));
    }
}