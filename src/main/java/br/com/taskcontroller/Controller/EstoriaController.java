package br.com.taskcontroller.Controller;

import br.com.taskcontroller.Mapper.EstoriaMapper;
import br.com.taskcontroller.Modelo.Epico;
import br.com.taskcontroller.Modelo.Estoria;
import br.com.taskcontroller.Modelo.StatusEntidades;
import br.com.taskcontroller.Modelo.Usuario;
import br.com.taskcontroller.Record.Estoria.EstoriaInclusaoDTO;
import br.com.taskcontroller.Respository.*;
import br.com.taskcontroller.Service.EstoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estorias")
public class EstoriaController {

    @Autowired
    private EstoriaService service;

    @Autowired
    private EpicoRepository epicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private StatusEntidadesRepository statusEntidadesRepository;

    // BUSCAR POR ID
    @GetMapping("/{idEstoria}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long idEstoria) {
        try {
            Estoria Estoria = service.buscarPorId(idEstoria);
            return ResponseEntity.ok().body(Estoria);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Estória não encontrado");
        }
    }

    // SALVAR
    @PostMapping("/salvar")
    public Estoria salvar(@RequestBody EstoriaInclusaoDTO dto) {
        Estoria estoria;
        if(dto.getIdestoria() == null) {
            estoria = EstoriaMapper.toEntity(dto);
        }
        else {
            estoria = service.buscarPorId(dto.getIdestoria());
            estoria.setDescestoria(dto.getDescestoria());
            estoria.setBloqueada(dto.isBloqueada());
            estoria.setResumo(dto.getResumo());
            estoria.setData_inicio(dto.getData_inicio());
            estoria.setData_fim(dto.getData_fim());
            estoria.setPontos(dto.getPontos());
            estoria.setHoras_estimadas(dto.getHoras_estimadas());
            estoria.setHoras_realizadas(dto.getHoras_realizadas());
            estoria.setAtiva(dto.isAtiva());
            estoria.setTags(dto.getTags());
            estoria.setCriterios(dto.getCriterios());
        }
        Epico epico = epicoRepository.findById(dto.getIdepico()).orElseThrow();
        estoria.setEpico(epico);

        StatusEntidades status = statusEntidadesRepository.findById(dto.getIdstatus()).orElseThrow();

        Usuario criador = usuarioRepository.findById(dto.getIdcriador()).orElseThrow();

        Usuario responsavel = usuarioRepository.findById(dto.getIdresponsavel()).orElseThrow();

        estoria.setStatus(status);
        estoria.setCriador(criador);
        estoria.setResponsavel(responsavel);
        return service.salvar(estoria);
    }

    // ATUALIZAR
    @PutMapping("/atualizar/{idEstoria}")
    public Estoria atualizar(@PathVariable Long idEstoria,
                             @RequestBody Estoria Estoria) {

        Estoria.setIdestoria(idEstoria);

        return service.atualizar(Estoria);
    }

    // LISTAR
    @GetMapping("/listar")
    public List<Estoria> listar() {
        return service.listar();
    }

    // EXCLUIR
    @DeleteMapping("/excluir/{idEstoria}")
    public ResponseEntity<String> excluir(@PathVariable Long idEstoria) {
        service.excluir(idEstoria);
        return ResponseEntity.ok().body("Estoria excluída com sucesso!");
    }
}