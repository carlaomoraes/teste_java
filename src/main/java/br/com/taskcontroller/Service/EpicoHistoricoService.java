package br.com.taskcontroller.Service;

import lombok.RequiredArgsConstructor;
import br.com.taskcontroller.Modelo.Epico;
import br.com.taskcontroller.Modelo.Usuario;
import org.springframework.stereotype.Service;
import br.com.taskcontroller.Enums.TipoAlteracao;
import br.com.taskcontroller.Modelo.EpicoHistorico;
import br.com.taskcontroller.Record.Epico.EpicoHistoricoDTO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.taskcontroller.Respository.EpicoHistoricoRepository;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class EpicoHistoricoService {

    private final EpicoHistoricoRepository repository;

    @Transactional(propagation = Propagation.MANDATORY)
    public void registrar(
            Epico epico,
            Usuario usuario,
            TipoAlteracao tipo,
            String valorAnterior,
            String valorNovo,
            String descricao) {

        EpicoHistorico historico = new EpicoHistorico();

        historico.setEpico(epico);
        historico.setUsuario(usuario);
        historico.setTipo_alteracao(tipo);
        historico.setValor_anterior(valorAnterior);
        historico.setValor_novo(valorNovo);
        historico.setDescricao(descricao);

        repository.save(historico);
    }
    @Transactional(readOnly = true)
    public List<EpicoHistoricoDTO> listar(Long idEpico) {

        return repository
                .findByEpicoIdepicoOrderByIdhistoricoDesc(idEpico)
                .stream()
                .map(h -> new EpicoHistoricoDTO(
                        h.getIdhistorico(),
                        h.getEpico().getIdepico(),
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