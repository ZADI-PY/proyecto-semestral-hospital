package ms_camas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import ms_camas.dto.CamaRequestDTO;
import ms_camas.model.Cama;
import ms_camas.service.CamaService;

@RestController
@RequestMapping("/api/v1/camas")
public class CamaController {

    @Autowired
    private CamaService camaService;

    @PostMapping
    public ResponseEntity<Cama> registrarCama(@Valid @RequestBody CamaRequestDTO dto) {
        Cama cama = new Cama();
        cama.setNumeroCama(dto.getNumeroCama());
        cama.setSala(dto.getSala());
        Cama nuevaCama = camaService.registrarCama(cama);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCama);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<Iterable<Cama>> listarCamasPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(camaService.listarPorEstado(estado));
    }

    @PutMapping("/{numeroCama}/asignar/{runPaciente}")
    public ResponseEntity<Cama> asignarPaciente(@PathVariable String numeroCama, @PathVariable String runPaciente) {
        return ResponseEntity.ok(camaService.asignarPaciente(numeroCama, runPaciente));
    }
}