package br.com.taskcontroller.Projection;

import java.time.LocalDate;

 public interface GridEmpreendimentoProjection {
     Long getIdempreendimento();
     String getDescempreendimento();
     LocalDate getData_inicio();
     LocalDate getData_fim();
     LocalDate getData_cadastro();
     String getPrioridade();
     String getStatus();
     String getsiglaempreendimento();
     String getCor();
     String getIdgestor();
     String getNomeGestor();
//     Long getPercentual();
//     boolean getBloqueado();
//     String getCodempreendimento();
//     Integer getAtivo();
//     Integer getDuracao_min_sprint();
//     Integer getDuracao_max_sprint();
//     Boolean getPermitir_multiplas_sprint_ativas();
//     Integer getHoras_trabalho_dia();
//     Boolean getConsiderar_Feriados();
//     Boolean getConsiderar_valorhoras();
}