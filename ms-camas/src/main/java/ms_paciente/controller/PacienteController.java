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
import ms_paciente.model.Paciente;
import ms_paciente.service.PacienteService;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listar() {
        List<Paciente> pacientes = pacienteService.findAll();
        if (pacientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id) {
        try {
            Paciente paciente = pacienteService.findById(id);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Fíjate que ahora recibe PacienteRequestDTO
    @PostMapping
    public ResponseEntity<Paciente> guardar(@Valid @RequestBody ms_paciente.dto.PacienteRequestDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setRun(dto.getRun());
        paciente.setNombres(dto.getNombres());
        paciente.setApellidos(dto.getApellidos());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setCorreo(dto.getCorreo());
        
        Paciente pacienteNuevo = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Integer id, @Valid @RequestBody ms_paciente.dto.PacienteRequestDTO dto) {
        try {
            Paciente pac = pacienteService.findById(id);
            pac.setRun(dto.getRun());
            pac.setNombres(dto.getNombres());
            pac.setApellidos(dto.getApellidos());
            pac.setFechaNacimiento(dto.getFechaNacimiento());
            pac.setCorreo(dto.getCorreo());
            
            pacienteService.save(pac);
            return ResponseEntity.ok(pac);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            pacienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}