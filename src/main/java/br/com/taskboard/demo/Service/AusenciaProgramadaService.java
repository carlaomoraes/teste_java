package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.AusenciaProgramada;
import br.com.taskboard.demo.Modelo.TipoAusencia;
import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.AusenciaProgramadaRepository;
import br.com.taskboard.demo.Respository.AusenciaProgramadaUsuarioRepository;
import br.com.taskboard.demo.Respository.TipoAusenciaRepository;
import br.com.taskboard.demo.Respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AusenciaProgramadaService {

    @Autowired
    private AusenciaProgramadaRepository repository;

    @Autowired
    private UsuarioRepository repositoryUsuario;

    @Autowired
    private TipoAusenciaRepository repositoryTipoAusencia;

    @Autowired
    private AusenciaProgramadaUsuarioRepository repositoryAusenciaProgramadaUsuario;

    public AusenciaProgramada salvar(AusenciaProgramada ausenciaProgramada) {
        TipoAusencia tipoAusencia = repositoryTipoAusencia.findById(ausenciaProgramada.getTipoausencia().getId_tipo_ausencia()).orElseThrow();
        Usuario usuario = repositoryUsuario.findById(ausenciaProgramada.getIdusuario().getIdusuario()).orElseThrow();
        ausenciaProgramada.setIdusuario(usuario);
        ausenciaProgramada.setTipoausencia(tipoAusencia);
        return repository.save(ausenciaProgramada);
    }

    public List<AusenciaProgramada> listar() {

        return repository.findAll();
    }

    public AusenciaProgramada atualizar(AusenciaProgramada ausenciaProgramada) {
        TipoAusencia tipoAusencia = repositoryTipoAusencia.findById(ausenciaProgramada.getTipoausencia().getId_tipo_ausencia()).orElseThrow();
        Usuario usuario = repositoryUsuario.findById(ausenciaProgramada.getIdusuario().getIdusuario()).orElseThrow();
        ausenciaProgramada.setIdusuario(usuario);
        ausenciaProgramada.setTipoausencia(tipoAusencia);
        return repository.save(ausenciaProgramada);
    }
    public void excluir(Long idAusencia) {
        repository.deleteById(idAusencia);
    }

    public AusenciaProgramada buscarPorId(Long idAusencia) {
        return repository.findById(idAusencia).orElseThrow(() -> new RuntimeException("Ausência não encontrada"));
    }

    public List<AusenciaProgramada> listarAuasenciaPorUsuario(Long idUsuario) {
        return repositoryAusenciaProgramadaUsuario.buscarPorUsuario(idUsuario);
    }
}