package ms_facturacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms_facturacion.model.Factura;
import ms_facturacion.repository.FacturaRepository;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    // 1. Guardar o Actualizar una factura
    public Factura guardar(Factura factura) {

        return facturaRepository.save(factura);
    }

    // 2. Listar todas las facturas
    public Iterable<Factura> listarTodas() {
        return facturaRepository.findAll();
    }

    // 3. Buscar una factura específica por su ID
    public Factura buscarPorId(Integer id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada en el sistema"));
    }

    // 4. Eliminar una factura
    public void eliminar(Integer id) {
        facturaRepository.deleteById(id);
    }
}