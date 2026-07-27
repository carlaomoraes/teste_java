package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.StatusTransicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatusEntidadeRepository
        extends JpaRepository<StatusEntidades, Long> {;
}