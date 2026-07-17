package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {
    Optional<Configuracao> findByEmpreendimentoIdempreendimento(Long idempreendimento);
}
