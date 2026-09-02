package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.Papel;
import br.com.taskcontroller.Record.Papel.PapelComboDTO;
import br.com.taskcontroller.Record.Papel.PapelListagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PapelRepository extends JpaRepository<Papel, Long> {
    @Query("""
    SELECT new br.com.taskcontroller.Record.Papel.PapelComboDTO(
        p.idpapel,
        p.descpapel,
        p.valorhora,
        p.ativo,
        p.tipopapel
    )
    FROM Papel p
   WHERE p.ativo = true
     AND p.tipopapel = 1
    ORDER BY p.idpapel
    """)
    List<PapelComboDTO> montaComboPapel();

    @Query("""
    SELECT new br.com.taskcontroller.Record.Papel.PapelListagemDTO(
        p.idpapel,
        p.descpapel,
        p.valorhora,
        p.ativo,
        p.tipopapel,
        case when p.tipopapel = 1 then "Administrativo"
             else "Operacional"
        end as desctipopapel
    )
    FROM Papel p
    ORDER BY p.idpapel
    """)
    List<PapelListagemDTO> listaPapel();

    @Query("""
    SELECT new br.com.taskcontroller.Record.Papel.PapelListagemDTO(
        p.idpapel,
        p.descpapel,
        p.valorhora,
        p.ativo,
        p.tipopapel,
        case when p.tipopapel = 1 then "Administrativo"
             else "Operacional"
        end as desctipopapel
    )
    FROM Papel p
   WHERE p.idpapel = :ipdapel
    """)
    PapelListagemDTO buscaPapel(Long ipdapel);
}
