package ms_historial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ms_historial.model.Historial;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Integer> {
    // Busca todas las atenciones de un paciente ordenadas por la fecha más reciente
    Iterable<Historial> findByRunPacienteOrderByFechaAtencionDesc(String runPaciente);
}