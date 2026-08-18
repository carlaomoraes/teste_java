package br.com.taskcontroller.Record.Estoria;

public record EstoriaBacklogDTO(
        Long idestoria,
        String descestoria,
        Long idstatus,
        String descstatus,
        Long idcriador,
        String nomecriador,
        Long idresponsavel,
        String nomeesponsavel,
        String resumo,
        Long pontos,
        Long idepico,
        String nome,
        Long idprioridades,
        String descprioridades)
{
}