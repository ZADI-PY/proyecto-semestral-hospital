package ms_camas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ms_camas.model.Cama;
import java.util.Optional;

@Repository
public interface CamaRepository extends JpaRepository<Cama, Integer> {
    // Busca camas filtrando por su estado (útil para ver cuáles están DISPONIBLES)
    Iterable<Cama> findByEstado(String estado);
    
    // Busca una cama exacta por su código
    Optional<Cama> findByNumeroCama(String numeroCama);
}