package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Configuracao;
import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Respository.ConfiguracaoRepository;
import br.com.taskcontroller.Respository.EmpreendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository repository;

    @Autowired
    private EmpreendimentoRepository empreendimentoRepository;

    public Configuracao salvar(Configuracao configuracao) {
        Empreendimento empreendimento = empreendimentoRepository.findById(configuracao.getEmpreendimento().getIdempreendimento()).orElse(null);
        if(empreendimento == null) {
            throw new RuntimeException("Empreendimento não encontrado!");
        }
        configuracao.setEmpreendimento(empreendimento);
        return repository.save(configuracao);
    }

    public List<Configuracao> listar() {
        return repository.findAll();
    }

    public Configuracao atualizar(Configuracao Configuracao) {
        return repository.save(Configuracao);
    }

    public void excluir(Long idConfiguracao) {
        repository.deleteById(idConfiguracao);
    }

    public Configuracao buscarPorId(Long idConfiguracao) {
        return repository.findById(idConfiguracao).orElseThrow(() -> new RuntimeException("Configuracao não encontrado"));
    }

    public Configuracao buscarPorEmpreendimento(Empreendimento empreendimento) {
        return repository.findByEmpreendimento(empreendimento).orElse(null);
    }
}