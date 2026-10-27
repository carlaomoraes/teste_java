package br.com.taskcontroller.Service;

import br.com.taskcontroller.Enums.TipoAlteracao;
import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Modelo.SprintHistorico;
import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Record.Sprint.SprintHistoricoDTO;
import br.com.taskcontroller.Respository.SprintHistoricoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SprintHistoricoService {

    private final SprintHistoricoRepository repository;

    @Transactional(propagation = Propagation.MANDATORY)
    public void registrar(
            Sprint sprint,
            Usuario usuario,
            TipoAlteracao tipo,
            String valorAnterior,
            String valorNovo,
            String descricao) {

        SprintHistorico historico = new SprintHistorico();

        historico.setSprint(sprint);
        historico.setUsuario(usuario);
        historico.setTipo_alteracao(tipo);
        historico.setValor_anterior(valorAnterior);
        historico.setValor_novo(valorNovo);
        historico.setDescricao(descricao);

        repository.save(historico);
    }
    @Transactional(readOnly = true)
    public List<SprintHistoricoDTO> listar(Long idsprint) {

        return repository
                .findBySprint_IdsprintOrderByDataAlteracaoDesc(idsprint)
                .stream()
                .map(h -> new SprintHistoricoDTO(
                        h.getIdhistorico(),
                        h.getSprint().getIdsprint(),
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