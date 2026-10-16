package br.com.taskcontroller.Service;

import br.com.taskcontroller.Record.Sprint.SprintIndicadoresDTO;
import br.com.taskcontroller.Respository.SprintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SprintIndicadoresService {

    private final SprintRepository sprintRepository;

    public SprintIndicadoresDTO carregaIndicadores(Long idSprint) {
        LocalDate hoje = LocalDate.now();
        Long concluidas = sprintRepository.contarConcluidas(idSprint);
        Long emandamento = sprintRepository.contarEmAndamento(idSprint, hoje);
        Long atrasadas =  sprintRepository.contarAtrasadas(idSprint, hoje);

        return new SprintIndicadoresDTO(
                concluidas,
                emandamento,
                atrasadas,
                BigDecimal.ZERO
        );
    }
}