package br.com.taskcontroller.Service;


import br.com.taskcontroller.Record.COMBO.EmpreendimentoComboDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaBacklogDTO;
import br.com.taskcontroller.Respository.EmpreendimentoRepository;
import br.com.taskcontroller.Respository.EpicoEstoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogService {

    @Autowired
    private EpicoEstoriasRepository repository;

    @Autowired
    private EmpreendimentoRepository repositoryEmpreendimento;


    public List<EstoriaBacklogDTO> listar(Long idempreendimento) {
        return repository.listaEstoriasBacklog(idempreendimento);
    }

    public List<EmpreendimentoComboDTO> montaComboEmpreendimento() {
        return repositoryEmpreendimento.montaComboEmpreendimento();
    }
}