package ms_agendamiento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ms_agendamiento.model.Agendamiento;
import ms_agendamiento.repository.AgendamientoRepository;

@Service
public class AgendamientoService {

    @Autowired
    private AgendamientoRepository agendamientoRepository;

    public Agendamiento agendarHora(Agendamiento agendamiento) {
        agendamiento.setEstado("VIGENTE");
        return agendamientoRepository.save(agendamiento);
    }

    public Iterable<Agendamiento> verAgendaMedico(String runMedico) {
        return agendamientoRepository.findByRunMedicoOrderByFechaHoraAsc(runMedico);
    }

    public Iterable<Agendamiento> verHorasPaciente(String runPaciente) {
        return agendamientoRepository.findByRunPacienteOrderByFechaHoraAsc(runPaciente);
    }
}
