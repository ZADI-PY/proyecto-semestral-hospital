package ms_paciente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ms_paciente.dto.MedicoRequestDTO;
import ms_paciente.model.Medico;
import ms_paciente.service.MedicoService;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Medico>> listar() {
        List<Medico> medicos = medicoService.findAll();
        if (medicos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscar(@PathVariable Integer id) {
        try {
            Medico medico = medicoService.findById(id);
            return ResponseEntity.ok(medico);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Medico> guardar(@Valid @RequestBody MedicoRequestDTO dto) {
        Medico medico = new Medico();
        medico.setRun(dto.getRun());
        medico.setNombres(dto.getNombres());
        medico.setApellidos(dto.getApellidos());
        medico.setEspecialidad(dto.getEspecialidad());
        medico.setCorreo(dto.getCorreo());

        Medico medicoNuevo = medicoService.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizar(@PathVariable Integer id, @Valid @RequestBody MedicoRequestDTO dto) {
        try {
            Medico medico = medicoService.findById(id);
            medico.setRun(dto.getRun());
            medico.setNombres(dto.getNombres());
            medico.setApellidos(dto.getApellidos());
            medico.setEspecialidad(dto.getEspecialidad());
            medico.setCorreo(dto.getCorreo());

            medicoService.save(medico);
            return ResponseEntity.ok(medico);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            medicoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}