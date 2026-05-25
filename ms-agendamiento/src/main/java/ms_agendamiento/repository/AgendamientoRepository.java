package ms_agendamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ms_agendamiento.model.Agendamiento;

@Repository
public interface AgendamientoRepository extends JpaRepository<Agendamiento, Integer> {
    // Para que el médico pueda ver todos los pacientes que tiene en el día/semana
    Iterable<Agendamiento> findByRunMedicoOrderByFechaHoraAsc(String runMedico);
    
    // Para que el paciente vea sus próximas horas
    Iterable<Agendamiento> findByRunPacienteOrderByFechaHoraAsc(String runPaciente);
}