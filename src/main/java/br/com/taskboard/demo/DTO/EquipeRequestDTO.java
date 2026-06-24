package br.com.taskboard.demo.DTO;

public class EquipeRequestDTO {
   private Long idequipe;
   private String nomeequipe;
   private String descequipe;
   private String ativa;

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

    public String getAtiva() {
        return ativa;
    }

    public void setAtiva(String ativa) {
        this.ativa = ativa;
    }
}