package br.com.taskcontroller.Service;

import br.com.taskcontroller.Enums.TipoAlteracao;
import br.com.taskcontroller.Modelo.Tarefa;
import br.com.taskcontroller.Modelo.TarefaHistorico;
import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Record.Tarefa.TarefaHistoricoDTO;
import br.com.taskcontroller.Respository.TarefaHistoricoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaHistoricoService {

    private final TarefaHistoricoRepository repository;

    @Transactional(propagation = Propagation.MANDATORY)
    public void registrar(
            Tarefa tarefa,
            Usuario usuario,
            TipoAlteracao tipo,
            String valorAnterior,
            String valorNovo,
            String descricao) {

        TarefaHistorico historico = new TarefaHistorico();

        historico.setTarefa(tarefa);
        historico.setUsuario(usuario);
        historico.setTipo_alteracao(tipo);
        historico.setValor_anterior(valorAnterior);
        historico.setValor_novo(valorNovo);
        historico.setDescricao(descricao);

        repository.save(historico);
    }
    @Transactional(readOnly = true)
    public List<TarefaHistoricoDTO> listar(Long idTarefa) {

        return repository
                .findByTarefaIdtarefaOrderByIdhistoricoDesc(idTarefa)
                .stream()
                .map(h -> new TarefaHistoricoDTO(
                        h.getIdhistorico(),
                        h.getTarefa().getIdtarefa(),
                        h.getUsuario().getIdusuario(),
                        h.getUsuario().getNome(),
                        LocalDateTime.parse(h.getDataAlteracao().format(DateTimeFormatter.ofPattern("DD/MM/YYYY"))),
                        h.getTipo_alteracao(),
                        h.getValor_anterior(),
                        h.getValor_novo(),
                        h.getDescricao()
                ))
                .toList();
    }
}