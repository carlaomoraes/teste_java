package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.AusenciaProgramada;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.StatusTransicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
public interface StatusTransicaoRepository
        extends JpaRepository<StatusTransicao, Long> {

    List<StatusTransicao> findByStatusOrigemIdstatusOrderByStatusDestinoOrdem(Long idStatus);}