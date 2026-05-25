package ms_medico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import ms_medico.dto.MedicoRequestDTO;
import ms_medico.model.Medico;
import ms_medico.service.MedicoService;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Medico> registrar(@Valid @RequestBody MedicoRequestDTO dto) {
        Medico medico = new Medico();
        medico.setRun(dto.getRun());
        medico.setNombre(dto.getNombre());
        medico.setApellido(dto.getApellido());
        medico.setEspecialidad(dto.getEspecialidad());
        medico.setCorreo(dto.getCorreo());

        Medico nuevoMedico = medicoService.registrarMedico(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMedico);
    }

    @GetMapping("/{run}")
    public ResponseEntity<Medico> obtenerPorRun(@PathVariable String run) {
        Optional<Medico> medico = medicoService.buscarPorRun(run);
        return medico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Medico>> listarTodos() {
        return ResponseEntity.ok(medicoService.listarTodos());
    }
}