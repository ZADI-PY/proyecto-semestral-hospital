package ms_paciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ms_paciente.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    
    // Este método servirá más adelante para verificar si un médico ya existe por su RUN
    boolean existsByRun(String run);
}