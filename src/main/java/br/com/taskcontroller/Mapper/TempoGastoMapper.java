package br.com.taskcontroller.Mapper;

import br.com.taskcontroller.DTO.ConfiguracaoResponseDTO;
import br.com.taskcontroller.DTO.TempoGastoRequestDTO;
import br.com.taskcontroller.DTO.TempoGastoResponseDTO;
import br.com.taskcontroller.Modelo.Configuracao;
import br.com.taskcontroller.Modelo.Tarefa;
import br.com.taskcontroller.Modelo.TempoGasto;
import br.com.taskcontroller.Modelo.Usuario;

public class TempoGastoMapper {

    public static TempoGasto toEntity(TempoGastoRequestDTO dto) {
        TempoGasto tempoGasto = new TempoGasto();
        tempoGasto.setIdtempogasto(dto.getIdtempo_gasto());
        Tarefa tarefa = new Tarefa();
        tarefa.setIdtarefa(dto.getTarefa().getIdtarefa());
        tempoGasto.setTarefa(tarefa);
        Usuario  usuario = new Usuario();
        usuario.setIdusuario(dto.getUsuario().getIdusuario());
        tempoGasto.setUsuario(usuario);
        tempoGasto.setHora_execucao(dto.getHora_execucaoo());
        tempoGasto.setData_execucao(dto.getData_execucao());
        tempoGasto.setDuracao(dto.getDuracao());
        return tempoGasto;
    }

    public static TempoGastoResponseDTO toDTO(TempoGasto t) {
        TempoGastoResponseDTO dto = new TempoGastoResponseDTO();
        dto.setIdtempo_gasto(t.getIdtempogasto());
        dto.setTarefa(t.getTarefa());
        dto.setUsuario(t.getUsuario());
        dto.setDuracao(t.getDuracao());
        dto.setData_execucao(t.getData_execucao());
        dto.setHora_execucaoo(t.getHora_execucao());
        return dto;
    }
}