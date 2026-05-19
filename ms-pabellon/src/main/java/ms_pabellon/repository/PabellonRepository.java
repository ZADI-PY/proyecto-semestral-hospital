package ms_pabellon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ms_pabellon.model.Pabellon;

@Repository
public interface PabellonRepository extends JpaRepository<Pabellon, Integer> {
    // Método extra para buscar pabellones según su estado actual
    Iterable<Pabellon> findByEstado(String estado);
}