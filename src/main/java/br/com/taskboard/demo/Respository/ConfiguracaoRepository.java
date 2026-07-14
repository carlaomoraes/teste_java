package br.com.taskboard.demo.Respository;

import br.com.taskboard.demo.Modelo.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {

}
