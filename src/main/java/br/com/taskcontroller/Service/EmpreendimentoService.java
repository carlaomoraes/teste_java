package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.Empreendimento;
import br.com.taskcontroller.Modelo.Empreendimento_Equipe;
import br.com.taskcontroller.Modelo.Equipe;
import br.com.taskcontroller.Record.EmpreendimentoDTO;
import br.com.taskcontroller.Respository.EmpreendimentoRepository;
import br.com.taskcontroller.Respository.EquipeEmpreendimentoRepository;
import br.com.taskcontroller.Respository.EquipeRepository;
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

    public void excluir(Long id) {
        Empreendimento empreendimento = empreendimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empreendimento não encontrado."));
        empreendimento.setAtivo(0);
        empreendimentoRepository.save(empreendimento);
    }

    public List<EmpreendimentoDTO> listar() {
        return empreendimentoRepository.findByAtivoTrue();
    }


    //===================================
    // EQUIPES
    //===================================
    public void adicionarEquipe(Long idEmpreendimento, Long idEquipe) {
        long cont = relacionamentoRepository.contarRelacionamentos(idEmpreendimento, idEquipe);
        if (cont > 1) {
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

    public void removerEquipe(Long idEmpreendimento,Long idEquipe) {
            relacionamentoRepository.removerMembro(idEquipe,idEmpreendimento);
    }

    public List<Equipe> listarEquipes(Long idEmpreendimento) {
        return relacionamentoRepository.buscarEquipesPorEmpreendimento(idEmpreendimento);
    }

    public List<Equipe> listarEquipesDisponiveis(Long idEmpreendimento) {
        return relacionamentoRepository.buscarEquipesDisponiveis(idEmpreendimento);
    }


}