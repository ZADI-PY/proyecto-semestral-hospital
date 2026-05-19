package ms_facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ms_facturacion.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    // Busca todas las facturas de un paciente específico
    Iterable<Factura> findByRunPaciente(String runPaciente);
    
    // Busca facturas filtrando por su estado (ej: para cobrar las PENDIENTES)
    Iterable<Factura> findByEstado(String estado);
}