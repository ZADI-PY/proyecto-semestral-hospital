package ms_inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ms_inventario.model.Insumo;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Integer> {
    // Busca insumos cuyo nombre contenga cierta palabra (útil para el buscador)
    Iterable<Insumo> findByNombreContainingIgnoreCase(String nombre);
}