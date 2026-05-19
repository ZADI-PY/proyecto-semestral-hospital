package ms_facturacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import ms_facturacion.dto.FacturaRequestDTO;
import ms_facturacion.model.Factura;
import ms_facturacion.service.FacturaService;

@RestController
@RequestMapping("/api/v1/facturacion")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping
    public ResponseEntity<Factura> generarCobro(@Valid @RequestBody FacturaRequestDTO dto) {
        Factura factura = new Factura();
        factura.setRunPaciente(dto.getRunPaciente());
        factura.setMontoTotal(dto.getMontoTotal());
        factura.setDetalleCargos(dto.getDetalleCargos());
        factura.setFechaEmision(dto.getFechaEmision());

        Factura nuevaFactura = facturaService.emitirFactura(factura);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFactura);
    }

    @GetMapping("/paciente/{run}")
    public ResponseEntity<Iterable<Factura>> obtenerFacturasPaciente(@PathVariable String run) {
        return ResponseEntity.ok(facturaService.obtenerPorPaciente(run));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<Iterable<Factura>> obtenerFacturasPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(facturaService.obtenerPorEstado(estado));
    }
}