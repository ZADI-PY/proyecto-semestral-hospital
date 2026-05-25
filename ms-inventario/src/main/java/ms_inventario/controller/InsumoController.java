package ms_inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import ms_inventario.dto.InsumoRequestDTO;
import ms_inventario.model.Insumo;
import ms_inventario.service.InsumoService;

@RestController
@RequestMapping("/api/v1/inventario")
public class InsumoController {

    @Autowired
    private InsumoService insumoService;

    @PostMapping
    public ResponseEntity<Insumo> registrarInsumo(@Valid @RequestBody InsumoRequestDTO dto) {
        Insumo insumo = new Insumo();
        insumo.setNombre(dto.getNombre());
        insumo.setCantidad(dto.getCantidad());
        insumo.setUnidadMedida(dto.getUnidadMedida());
        insumo.setUbicacion(dto.getUbicacion());

        Insumo nuevoInsumo = insumoService.guardarInsumo(insumo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoInsumo);
    }

    @GetMapping
    public ResponseEntity<Iterable<Insumo>> listarInventario() {
        return ResponseEntity.ok(insumoService.listarTodos());
    }

    @GetMapping("/buscar")
    public ResponseEntity<Iterable<Insumo>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(insumoService.buscarPorNombre(nombre));
    }
}