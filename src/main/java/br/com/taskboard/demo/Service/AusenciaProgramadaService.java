package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.AusenciaProgramada;
import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.Respository.AusenciaProgramadaRepository;
import br.com.taskboard.demo.Respository.AusenciaProgramadaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AusenciaProgramadaService {

    @Autowired
    private AusenciaProgramadaRepository repository;

    @Autowired
    private AusenciaProgramadaUsuarioRepository repositoryUsuario;

    public AusenciaProgramada salvar(AusenciaProgramada ausenciaProgramada) {

        return repository.save(ausenciaProgramada);
    }

    public List<AusenciaProgramada> listar() {

        return repository.findAll();
    }

    public AusenciaProgramada atualizar(AusenciaProgramada ausenciaProgramada) {
        return repository.save(ausenciaProgramada);
    }
    public void excluir(Long idAusencia) {
        repository.deleteById(idAusencia);
    }

    public AusenciaProgramada buscarPorId(Long idAusencia) {
        return repository.findById(idAusencia).orElseThrow(() -> new RuntimeException("Ausência não encontrada"));
    }

    public List<AusenciaProgramada> listarAuasenciaPorUsuario(Long idUsuario) {
        return repositoryUsuario.buscarPorUsuario(idUsuario);
    }
}