package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Empreendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long> {

    List<Empreendimento> findByAtivoTrue();
}
