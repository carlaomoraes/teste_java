package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.Configuracao;
import br.com.taskboard.demo.Respository.ConfiguracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository repository;

    public Configuracao atualizar(Configuracao Configuracao) {
        return repository.save(Configuracao);
    }

    public Configuracao buscarPorId(Long idConfiguracao) {
        return repository.findById(idConfiguracao).orElseThrow(() -> new RuntimeException("Configuração não encontrada"));
    }
}