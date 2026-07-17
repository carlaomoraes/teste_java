package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Configuracao;
import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Respository.ConfiguracaoRepository;
import br.com.taskcontroller.Respository.EmpreendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository repository;

    @Autowired
    private EmpreendimentoRepository empreendimentoRepository;

    public Configuracao atualizar(Configuracao configuracao) {
        if (configuracao.getEmpreendimento() == null ||
                configuracao.getEmpreendimento().getIdempreendimento() == null) {
            throw new RuntimeException("Empreendimento não informado.");
        }

        Empreendimento empreendimento = empreendimentoRepository
                .findById(configuracao.getEmpreendimento().getIdempreendimento())
                .orElseThrow(() -> new RuntimeException("Empreendimento não encontrado."));

        Configuracao novaConfiguracao = repository.findById(configuracao.getIdconfiguracao()).orElse(null);
        novaConfiguracao.setIdconfiguracao(configuracao.getIdconfiguracao());
        novaConfiguracao.setEmpreendimento(empreendimento);
        novaConfiguracao.setDuracao_min_sprint(configuracao.getDuracao_min_sprint());
        novaConfiguracao.setDuracao_max_sprint(configuracao.getDuracao_max_sprint());
        novaConfiguracao.setPermitir_sprint_sobreposta(configuracao.getPermitir_sprint_sobreposta());
        novaConfiguracao.setPermitir_multiplas_sprint_ativas(configuracao.getPermitir_multiplas_sprint_ativas());
        novaConfiguracao.setHoras_trabalho_dia(configuracao.getHoras_trabalho_dia());
        novaConfiguracao.setConsiderar_Feriados(configuracao.getConsiderar_Feriados());
        return repository.save(novaConfiguracao);
    }

    public Configuracao buscarPorId(Long idConfiguracao) {
        return repository.findById(idConfiguracao).orElseThrow(() -> new RuntimeException("Configuração não encontrada"));
    }
    public Configuracao buscarConfiguracaoPorEmpreendimento(Long idempreendimento) {
        return repository.findByEmpreendimentoIdempreendimento(idempreendimento)
                .orElseThrow(() -> new RuntimeException("Configuração não encontrada"));

    }
}