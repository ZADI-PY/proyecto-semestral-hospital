package ms_recetas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import ms_recetas.dto.RecetaRequestDTO;
import ms_recetas.model.Receta;
import ms_recetas.service.RecetaService;

@RestController
@RequestMapping("/api/v1/recetas")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    @PostMapping
    public ResponseEntity<Receta> crearReceta(@Valid @RequestBody RecetaRequestDTO dto) {
        Receta receta = new Receta();
        receta.setRunPaciente(dto.getRunPaciente());
        receta.setRunMedico(dto.getRunMedico());
        receta.setMedicamentos(dto.getMedicamentos());
        receta.setIndicaciones(dto.getIndicaciones());
        receta.setFechaEmision(dto.getFechaEmision());

        Receta nuevaReceta = recetaService.emitirReceta(receta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReceta);
    }

    @GetMapping("/paciente/{run}")
    public ResponseEntity<Iterable<Receta>> obtenerPorPaciente(@PathVariable String run) {
        return ResponseEntity.ok(recetaService.obtenerRecetasPorPaciente(run));
    }
}