package br.com.taskcontroller.Respository;

import br.com.taskcontroller.Modelo.StatusEntidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusEntidadesRepository extends JpaRepository<StatusEntidades, Long> {
    @Query("""
    select st.statusDestino
    from StatusTransicao st
    where st.statusOrigem.idstatus = :idStatus
    order by st.statusDestino.ordem
""")
    List<StatusEntidades> buscarProximosStatus(Long idStatus);}
