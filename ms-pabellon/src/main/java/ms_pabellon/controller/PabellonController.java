package ms_pabellon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import ms_pabellon.dto.PabellonRequestDTO;
import ms_pabellon.model.Pabellon;
import ms_pabellon.service.PabellonService;

@RestController
@RequestMapping("/api/v1/pabellones")
public class PabellonController {

    @Autowired
    private PabellonService pabellonService;

    @PostMapping
    public ResponseEntity<Pabellon> agendarPabellon(@Valid @RequestBody PabellonRequestDTO dto) {
        Pabellon pabellon = new Pabellon();
        pabellon.setNumeroPabellon(dto.getNumeroPabellon());
        pabellon.setRunPaciente(dto.getRunPaciente());
        pabellon.setRunMedico(dto.getRunMedico());
        pabellon.setTipoCirugia(dto.getTipoCirugia());
        pabellon.setFechaCirugia(dto.getFechaCirugia());

        Pabellon nuevoPabellon = pabellonService.agendarCirugia(pabellon);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPabellon);
    }

    // Endpoint útil para saber qué cirugías están "EN_CURSO" o "PROGRAMADA"
    @GetMapping("/estado/{estado}")
    public ResponseEntity<Iterable<Pabellon>> obtenerPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(pabellonService.listarPorEstado(estado));
    }

// Listar TODOS los pabellones (GET a /api/v1/pabellones)
    @GetMapping
    public ResponseEntity<Iterable<Pabellon>> listarTodos() {
        try {
            return ResponseEntity.ok(pabellonService.listarTodos());
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    // Buscar UN pabellón por ID (GET a /api/v1/pabellones/1)
    @GetMapping("/{id}")
    public ResponseEntity<Pabellon> buscarPorId(@PathVariable Integer id) {
        try {
            Pabellon pabellon = pabellonService.buscarPorId(id);
            return ResponseEntity.ok(pabellon);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un pabellón por ID (DELETE a /api/v1/pabellones/1)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            pabellonService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}