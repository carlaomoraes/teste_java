package br.com.taskboard.demo.Service;

import br.com.taskboard.demo.Modelo.Status;
import br.com.taskboard.demo.Respository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository repository;

    public List<Status> listar() {

        return repository.findAll();
    }

}