package ms_reserva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ms_reserva.dto.ReservaRequestDTO;
import ms_reserva.model.Reserva;
import ms_reserva.service.ReservaService;

@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<?> crearReserva(@Valid @RequestBody ReservaRequestDTO dto) {
        Reserva reserva = new Reserva();
        reserva.setRunPaciente(dto.getRunPaciente());
        reserva.setRunMedico(dto.getRunMedico());
        reserva.setFechaHora(dto.getFechaHora());

        Reserva nuevaReserva = reservaService.agendarHora(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
    }
}