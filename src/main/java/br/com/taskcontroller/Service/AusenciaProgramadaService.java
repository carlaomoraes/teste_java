package br.com.taskcontroller.Service;

import br.com.taskcontroller.Modelo.AusenciaProgramada;
import br.com.taskcontroller.Record.AusenciaListagemDTO;
import br.com.taskcontroller.Respository.AusenciaProgramadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AusenciaProgramadaService {

    @Autowired
    private AusenciaProgramadaRepository repository;


    public AusenciaProgramada salvar(AusenciaProgramada ausenciaProgramada) {
        return repository.save(ausenciaProgramada);
    }

    public List<AusenciaProgramada> listar() {
        return repository.findAll();
    }

    public AusenciaProgramada atualizar(Long id, AusenciaProgramada novaAusenciaProgramada) {
        AusenciaProgramada ausenciaProgramada = buscarPorId(id);
        ausenciaProgramada.setIdausencia(novaAusenciaProgramada.getIdausencia());
        ausenciaProgramada.setIdusuario(novaAusenciaProgramada.getIdusuario());
        ausenciaProgramada.setData_inicio(novaAusenciaProgramada.getData_inicio());
        ausenciaProgramada.setData_fim(novaAusenciaProgramada.getData_fim());
        ausenciaProgramada.setObservacao(novaAusenciaProgramada.getObservacao());
        ausenciaProgramada.setData_cadastro(novaAusenciaProgramada.getData_cadastro());
        ausenciaProgramada.setTipoausencia(novaAusenciaProgramada.getTipoausencia());
        return repository.save(ausenciaProgramada);
    }
    public void excluir(Long idAusencia) {
        repository.deleteById(idAusencia);
    }

    public AusenciaProgramada buscarPorId(Long idAusencia) {
        return repository.findById(idAusencia).orElseThrow(() -> new RuntimeException("Ausência não encontrada"));
    }

    public List<AusenciaListagemDTO> listarPorUsuario(Long idUsuario) {
        return repository.findByIdusuario_Idusuario(idUsuario);
    }
}