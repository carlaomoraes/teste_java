package br.com.taskcontroller.DTO;

public class TipoAusenciaRequestDTO {
    private Long id_tipo_ausencia;
    private String desc_tipo_ausencia;
    public String cor_tipo_ausencia;

    public Long getId_tipo_ausencia() {
        return id_tipo_ausencia;
    }

    public void setId_tipo_ausencia(Long id_tipo_ausencia) {
        this.id_tipo_ausencia = id_tipo_ausencia;
    }

    public String getDesc_tipo_ausencia() {
        return desc_tipo_ausencia;
    }

    public void setDesc_tipo_ausencia(String desc_tipo_ausencia) {
        this.desc_tipo_ausencia = desc_tipo_ausencia;
    }

    public String getCor_tipo_ausencia() {
        return cor_tipo_ausencia;
    }

    public void setCor_tipo_ausencia(String cor_tipo_ausencia) {
        this.cor_tipo_ausencia = cor_tipo_ausencia;
    }
}
