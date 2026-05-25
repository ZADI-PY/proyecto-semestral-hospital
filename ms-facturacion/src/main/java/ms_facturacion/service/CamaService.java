package ms_facturacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ms_facturacion.model.Factura;
import ms_facturacion.repository.FacturaRepository;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public Factura emitirFactura(Factura factura) {
        factura.setEstado("PENDIENTE");
        return facturaRepository.save(factura);
    }

    public Iterable<Factura> obtenerPorPaciente(String runPaciente) {
        return facturaRepository.findByRunPaciente(runPaciente);
    }

    public Iterable<Factura> obtenerPorEstado(String estado) {
        return facturaRepository.findByEstado(estado);
    }
}