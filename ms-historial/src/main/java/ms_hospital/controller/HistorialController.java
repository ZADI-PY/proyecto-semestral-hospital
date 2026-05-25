package ms_historial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import ms_historial.dto.HistorialRequestDTO;
import ms_historial.model.Historial;
import ms_historial.service.HistorialService;

@RestController
@RequestMapping("/api/v1/historial")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @PostMapping
    public ResponseEntity<Historial> registrarAtencion(@Valid @RequestBody HistorialRequestDTO dto) {
        Historial historial = new Historial();
        historial.setRunPaciente(dto.getRunPaciente());
        historial.setRunMedico(dto.getRunMedico());
        historial.setDiagnostico(dto.getDiagnostico());
        historial.setTratamiento(dto.getTratamiento());
        historial.setFechaAtencion(dto.getFechaAtencion());
        historial.setObservaciones(dto.getObservaciones());

        Historial nuevoRegistro = historialService.registrarAtencion(historial);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRegistro);
    }

    @GetMapping("/paciente/{run}")
    public ResponseEntity<Iterable<Historial>> obtenerHistorialPaciente(@PathVariable String run) {
        return ResponseEntity.ok(historialService.obtenerHistorialPorPaciente(run));
    }
}