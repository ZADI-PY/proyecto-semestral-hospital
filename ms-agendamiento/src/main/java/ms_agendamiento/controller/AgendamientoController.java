package ms_agendamiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import ms_agendamiento.dto.AgendamientoRequestDTO;
import ms_agendamiento.model.Agendamiento;
import ms_agendamiento.service.AgendamientoService;

@RestController
@RequestMapping("/api/v1/agendamiento")
public class AgendamientoController {

    @Autowired
    private AgendamientoService agendamientoService;

    @PostMapping
    public ResponseEntity<Agendamiento> crearAgendamiento(@Valid @RequestBody AgendamientoRequestDTO dto) {
        Agendamiento agendamiento = new Agendamiento();
        agendamiento.setRunPaciente(dto.getRunPaciente());
        agendamiento.setRunMedico(dto.getRunMedico());
        agendamiento.setTipoConsulta(dto.getTipoConsulta());
        agendamiento.setBoxAtencion(dto.getBoxAtencion());
        agendamiento.setFechaHora(dto.getFechaHora());

        Agendamiento nuevaCita = agendamientoService.agendarHora(agendamiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCita);
    }

    @GetMapping("/medico/{run}")
    public ResponseEntity<Iterable<Agendamiento>> agendaDelMedico(@PathVariable String run) {
        return ResponseEntity.ok(agendamientoService.verAgendaMedico(run));
    }

    @GetMapping("/paciente/{run}")
    public ResponseEntity<Iterable<Agendamiento>> horasDelPaciente(@PathVariable String run) {
        return ResponseEntity.ok(agendamientoService.verHorasPaciente(run));
    }
}