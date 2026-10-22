package br.com.taskcontroller.DTO.Equipe;

public class EquipeRequestDTO {
   private Long idequipe;
   private String nomeequipe;
   private String descequipe;
   private boolean ativa;

    public Long getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(Long idequipe) {
        this.idequipe = idequipe;
    }

    public String getNomeequipe() {
        return nomeequipe;
    }

    public void setNomeequipe(String nomeequipe) {
        this.nomeequipe = nomeequipe;
    }

    public String getDescequipe() {
        return descequipe;
    }

    public void setDescequipe(String descequipe) {
        this.descequipe = descequipe;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}