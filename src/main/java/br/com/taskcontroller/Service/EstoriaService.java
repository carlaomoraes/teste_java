package br.com.taskcontroller.Service;


import br.com.taskcontroller.Enums.TipoAlteracao;
import br.com.taskcontroller.Excecoes.ResourceNotFoundException;
import br.com.taskcontroller.Modelo.*;
import br.com.taskcontroller.Record.COMBO.EstoriaComboDTO;
import br.com.taskcontroller.Record.Estoria.EstoriaHistoricoDTO;
import br.com.taskcontroller.Respository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EstoriaService {

    @Autowired
    private EstoriaRepository estoriaRepository;

    @Autowired
    private EpicoService epicoService;

    @Autowired
    private StatusEntidadesRepository statusEntidadesRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private EstoriaHistoricoRepository historicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EstoriaHistoricoService estoriaHistoricoService;

    public Estoria salvar(Estoria estoria) {
        Epico epico = epicoService.buscarPorId(estoria.getEpico().getIdepico());

        BigDecimal horas_realizadas = BigDecimal.ZERO;

        alterarStatus(estoria.getIdestoria(), estoria.getStatus().getIdstatus(),estoria.getResponsavel().getIdusuario());
        estoria.setEpico(epico);
        estoria.setHoras_realizadas(horas_realizadas);

        epicoService.atualizarPercentual(estoria.getEpico().getIdepico());

        return estoriaRepository.save(estoria);

    }

    public List<EstoriaComboDTO> listar() {

        return estoriaRepository.listar();
    }

    public Estoria atualizar(Estoria Estoria) {
        alterarStatus(Estoria.getIdestoria(), Estoria.getStatus().getIdstatus(), Estoria.getResponsavel().getIdusuario());
        return estoriaRepository.save(Estoria);
    }

    public void excluir(Long idEstoria) {
        Estoria estoria = estoriaRepository.findById(idEstoria)
                .orElseThrow(() -> new RuntimeException("Estória não encontrada !!!"));

        if (tarefaRepository.contarTarefasPendentes(estoria.getIdestoria()) > 0) {
            throw new RuntimeException("Não é possível inativar a estória porque existem tarefas ativas !!!");
        }

        estoria.setAtiva(false);

        estoriaRepository.save(estoria);
    }

    public Estoria buscarPorId(Long idEstoria) {
        return estoriaRepository.findById(idEstoria).orElseThrow(() -> new RuntimeException("Estória não encontrada !"));
    }

    @Transactional
    public void alterarResponsavel(Long idEstoria, Long idUsuario) {
        try {
            Estoria estoria = estoriaRepository.findById(idEstoria)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Estória não encontrada"));

            Usuario responsavelAnterior = usuarioService.buscarPorId(estoria.getResponsavel().getIdusuario());

            Usuario novoResponsavel = usuarioRepository.findById(idUsuario)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Usuário não encontrado"));

            if (responsavelAnterior != null &&
                    responsavelAnterior.getIdusuario().equals(novoResponsavel.getIdusuario())) {
                return;
            }

            String nomeAnterior = responsavelAnterior != null ? responsavelAnterior.getNome() : "Sem responsável";

            estoria.setResponsavel(novoResponsavel);

            estoriaHistoricoService.registrar(
                    estoria,
                    novoResponsavel,
                    TipoAlteracao.RESPONSAVEL,
                    nomeAnterior,
                    novoResponsavel.getNome(),
                    "Alteração de responsável da estória"
            );

            estoriaRepository.save(estoria);
        } catch (Exception e) {
            throw e;
        }

    }

    @Transactional
    public void alterarStatus(Long idEstoria, Long idStatus, Long idUsuario) {
        Usuario responsavel = usuarioService.buscarPorId(idUsuario);

        Estoria estoria = estoriaRepository.findById(idEstoria)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Estória não encontrada"));

        StatusEntidades statusAnterior = estoria.getStatus();

        StatusEntidades statusEntidades = statusEntidadesRepository.findById(idStatus)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Status não encontrado"));

        if (statusAnterior != null &&
                estoria.getStatus().getIdstatus().equals(statusEntidades.getIdstatus())) {
            return;
        }

        String nomeAnterior = statusAnterior.getDescstatus() != null ? estoria.getStatus().getDescstatus() : "Sem Status";


        estoriaHistoricoService.registrar(
                estoria,
                responsavel,
                TipoAlteracao.STATUS,
                nomeAnterior,
                statusEntidades.getDescstatus(),
                "Alteração de status da estória"
        );

    }
    public List<EstoriaHistoricoDTO> buscarHistorico(Long idEstoria) {
        return  historicoRepository.listaHistorico(idEstoria);
    }
}