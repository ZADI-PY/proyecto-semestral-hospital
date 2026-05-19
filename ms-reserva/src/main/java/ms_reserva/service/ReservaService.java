package ms_reserva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms_reserva.model.Reserva;
import ms_reserva.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva agendarHora(Reserva reserva) {
        // Por defecto, toda reserva nueva nace como PENDIENTE
        reserva.setEstado("PENDIENTE");
        return reservaRepository.save(reserva);
    }
}