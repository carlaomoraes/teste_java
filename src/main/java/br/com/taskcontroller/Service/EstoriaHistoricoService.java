package br.com.taskcontroller.Service;

import br.com.taskcontroller.Enums.TipoAlteracao;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.Tarefa.TarefaHistoricoDTO;
import br.com.taskcontroller.Respository.EstoriaHistoricoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstoriaHistoricoService {

    private final EstoriaHistoricoRepository repository;

    @Transactional(propagation = Propagation.MANDATORY)
    public void registrar(
            Estoria estoria,
            Usuario usuario,
            TipoAlteracao tipo,
            String valorAnterior,
            String valorNovo,
            String descricao) {

        EstoriaHistorico historico = new EstoriaHistorico();

        historico.setEstoria(estoria);
        historico.setUsuario(usuario);
        historico.setTipo_alteracao(tipo);
        historico.setValor_anterior(valorAnterior);
        historico.setValor_novo(valorNovo);
        historico.setDescricao(descricao);

        repository.save(historico);
    }
    @Transactional(readOnly = true)
    public List<TarefaHistoricoDTO> listar(Long idEstoria) {

        return repository
                .findByEstoriaIdestoriaOrderByIdhistoricoDesc(idEstoria)
                .stream()
                .map(h -> new TarefaHistoricoDTO(
                        h.getIdhistorico(),
                        h.getEstoria().getIdestoria(),
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