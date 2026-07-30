package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.ConfiguracaoRequestDTO;
import br.com.taskcontroller.DTO.ConfiguracaoResponseDTO;
import br.com.taskcontroller.Modelo.Configuracao;

public class ConfiguracaoMapper {

    public static Configuracao toEntity(ConfiguracaoRequestDTO dto) {
        Configuracao c = new Configuracao();
        c.setIdconfiguracao(dto.getIdconfiguracao());
        c.setEmpreendimento(dto.getEmpreendimento());
        c.setDuracao_max_sprint(dto.getDuracao_max_sprint());
        c.setDuracao_min_sprint(dto.getDuracao_min_sprint());
        c.setPermitir_multiplas_sprint_ativas(dto.getPermitir_multiplas_sprint_ativas());
        c.setPermitir_sprint_sobreposta(dto.getPermitir_sprint_sobreposta());
        c.setHoras_trabalho_dia(dto.getHoras_trabalho_dia());
        c.setConsiderar_Feriados(dto.getConsiderar_Feriados());
        c.setConsiderar_valorhoras(dto.getConsiderar_valorhoras());
        return c;
    }

    public static ConfiguracaoResponseDTO toDTO(Configuracao c) {
        ConfiguracaoResponseDTO dto = new ConfiguracaoResponseDTO();
        dto.setIdconfiguracao(c.getIdconfiguracao());
        dto.setEmpreendimento(c.getEmpreendimento());
        dto.setDuracao_max_sprint(c.getDuracao_max_sprint());
        dto.setDuracao_min_sprint(c.getDuracao_min_sprint());
        dto.setPermitir_multiplas_sprint_ativas(c.getPermitir_multiplas_sprint_ativas());
        dto.setPermitir_sprint_sobreposta(c.getPermitir_sprint_sobreposta());
        dto.setHoras_trabalho_dia(c.getHoras_trabalho_dia());
        dto.setConsiderar_Feriados(c.getConsiderar_Feriados());
        dto.setConsiderar_valorhoras(c.getConsiderar_valorhoras());

        return dto;
    }
}
