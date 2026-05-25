package ms_recetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ms_recetas.model.Receta;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Integer> {
    // Te dejo listo este método por si luego necesitas buscar todas las recetas de un paciente
    Iterable<Receta> findByRunPaciente(String runPaciente);
}