package br.com.taskcontroller.Mapper;


import br.com.taskcontroller.DTO.TempoGastoRequestDTO;
import br.com.taskcontroller.DTO.TempoGastoResponseDTO;
import br.com.taskcontroller.Modelo.Tarefa;
import br.com.taskcontroller.Modelo.TempoGasto;
import br.com.taskcontroller.Modelo.Usuario;

public class TempoGastoMapper {

    public static TempoGasto toEntity(TempoGastoRequestDTO dto) {
        TempoGasto tempoGasto = new TempoGasto();
        tempoGasto.setIdtempo_gasto(dto.getIdtempo_gasto());
        Tarefa tarefa = new Tarefa();
        tarefa.setIdtarefa(dto.getIdtarefa());
        tempoGasto.setTarefa(tarefa);
        Usuario usuario = new Usuario();
        usuario.setIdusuario(dto.getIdusuario());
        tempoGasto.setUsuario(usuario);
        tempoGasto.setHora_execucao(dto.getHora_execucaoo());
        tempoGasto.setData_execucao(dto.getData_execucao());
        tempoGasto.setResumo(dto.getResumo());
        return tempoGasto;
    }

    public static TempoGastoResponseDTO toDTO(TempoGasto t) {
        TempoGastoResponseDTO dto = new TempoGastoResponseDTO();
        dto.setIdtempo_gasto(t.getIdtempo_gasto());
        dto.setIdTarefa(t.getTarefa().getIdtarefa());
        dto.setIdusuario(t.getUsuario().getIdusuario());
        dto.setData_execucao(t.getData_execucao());
        dto.setHora_execucaoo(t.getHora_execucao());
        dto.setResumo(t.getResumo());
        return dto;
    }
}