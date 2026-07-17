package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface SprintRepository extends JpaRepository<Sprint, Long> {

    @Query("""
    select count(s)
    from Sprint s
    where s.dtiniciosprint <= :data_fim
      and s.dtfinalsprint >= :data_inicio
      and s.empreendimento.idempreendimento = :idempreendimento
      and (:idsprint is NULL OR s.idsprint <> :idsprint)
""")
    int buscaSprintPorIntervalo(@Param("data_inicio") LocalDate data_inicio,
                                @Param("data_fim") LocalDate data_fim,
                                @Param("idempreendimento") Long idempreendimento,
                                @Param("idsprint") Long idsprint);


}
