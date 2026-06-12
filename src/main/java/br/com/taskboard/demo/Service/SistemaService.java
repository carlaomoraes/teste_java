package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.Sistema;
import br.com.taskboard.demo.Respository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SistemaService {

    @Autowired
    private SistemaRepository repository;

    public Sistema salvar(Sistema Sistema) {
         return repository.save(Sistema);
    }

    public List<Sistema> listar() {

        return repository.findAll();
    }

    public Sistema atualizar(Sistema Sistema) {

        return repository.save(Sistema);
    }

    public void excluir(Long idSistema) {
        repository.deleteById(idSistema);
    }

    public Sistema buscarPorId(Long idSistema) {
        return repository.findById(idSistema).orElseThrow(() -> new RuntimeException("Tipo de sistema não encontrado"));
    }
}