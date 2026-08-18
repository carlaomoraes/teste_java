package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Sprint;
import br.com.taskcontroller.Projection.CabecalhoProjection;
import br.com.taskcontroller.Record.SprintDataDTO;
import br.com.taskcontroller.Record.SprintListagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    @Query("""
    select s.idsprint, s.empreendimento.idempreendimento, s.dtiniciosprint, s.dtfinalsprint
    from Sprint s
    where s.dtiniciosprint <= :data_fim
      and s.dtfinalsprint >= :data_inicio
      and s.empreendimento.idempreendimento = :idempreendimento
      and s.ativa = true
      and s.visivel = true
""")
    CabecalhoProjection montaCabecalho(@Param("idempreendimento") Long idempreendimento,
                                       @Param("idsprint") Long idsprint,
                                       @Param("data_inicio") LocalDate data_inicio,
                                       @Param("data_fim") LocalDate data_fim);

    @Query("""
    select new br.com.taskcontroller.Record.SprintListagemDTO(
            s.empreendimento.idempreendimento,
            s.idsprint,
            s.descsprint,
            s.dtiniciosprint,
            s.dtfinalsprint,
            s.ativa,
            s.visivel
            )
    from Sprint s
   where s.empreendimento.idempreendimento = :idempreendimento
""")
    List<SprintListagemDTO> listar(@Param("idempreendimento") Long idempreendimento);

    @Query("""
    SELECT new br.com.taskcontroller.Record.SprintDataDTO(
        s.idsprint,
        s.empreendimento.idempreendimento,
        s.descsprint,
        s.dtiniciosprint,
        s.dtfinalsprint,
        s.ativa,
        s.visivel,
        0)
    FROM Sprint s
    WHERE s.empreendimento.idempreendimento = :idEmpreendimento
      AND :hoje BETWEEN s.dtiniciosprint AND s.dtfinalsprint
""")
    Optional<SprintDataDTO> buscarSprintValida(
            @Param("idEmpreendimento") Long idEmpreendimento,
            @Param("hoje") LocalDate hoje
    );

    // CRIAR A CONSULTA PARA A TELA DO BACKLOG
}