package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.Empreendimento;
import br.com.taskboard.demo.Modelo.Empreendimento_Equipe;
import br.com.taskboard.demo.Modelo.Equipe;
import br.com.taskboard.demo.Respository.EmpreendimentoRepository;
import br.com.taskboard.demo.Respository.EquipeEmpreendimentoRepository;
import br.com.taskboard.demo.Respository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpreendimentoService {

    @Autowired
    private EmpreendimentoRepository empreendimentoRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private EquipeEmpreendimentoRepository relacionamentoRepository;

    // CRUD
    public Empreendimento salvar(Empreendimento empreendimento) {
        return empreendimentoRepository.save(empreendimento);
    }

    public Empreendimento atualizar(Empreendimento empreendimento) {
        return empreendimentoRepository.save(empreendimento);
    }

    public Empreendimento buscarPorId(Long id) {
        return empreendimentoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Empreendimento não encontrado."));
    }

    public List<Empreendimento> listar() {
        return empreendimentoRepository.findAll();
    }

    public void excluir(Long id) {
        empreendimentoRepository.deleteById(id);
    }

    //===================================
    // EQUIPES
    //===================================

    public void adicionarEquipe(Long idEmpreendimento, Long idEquipe) {

        if (relacionamentoRepository
                .existsByEmpreendimentoIdempreendimentoAndEquipeIdequipe(
                        idEmpreendimento,
                        idEquipe)) {

            throw new RuntimeException("Equipe já vinculada ao empreendimento.");
        }

        Empreendimento empreendimento = empreendimentoRepository.findById(idEmpreendimento)
                .orElseThrow(() ->
                        new RuntimeException("Empreendimento não encontrado."));

        Equipe equipe = equipeRepository.findById(idEquipe)
                .orElseThrow(() ->
                        new RuntimeException("Equipe não encontrada."));

        Empreendimento_Equipe relacionamento = new Empreendimento_Equipe();

        relacionamento.setEmpreendimento(empreendimento);
        relacionamento.setEquipe(equipe);

        relacionamentoRepository.save(relacionamento);
    }

    public void removerEquipe(Long idEmpreendimento,
                              Long idEquipe) {

        relacionamentoRepository.removerMembro(
                idEquipe,
                idEmpreendimento);
    }

    public List<Equipe> listarEquipes(Long idEmpreendimento) {

        return relacionamentoRepository
                .buscarEquipesPorEmpreendimento(idEmpreendimento);
    }

    public List<Equipe> listarEquipesDisponiveis(Long idEmpreendimento) {

        return relacionamentoRepository.buscarEquipesDisponiveis(idEmpreendimento);
    }
}