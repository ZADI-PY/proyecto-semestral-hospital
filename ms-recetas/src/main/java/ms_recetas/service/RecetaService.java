package ms_recetas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms_recetas.model.Receta;
import ms_recetas.repository.RecetaRepository;

@Service
public class RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;

    public Receta emitirReceta(Receta receta) {
        return recetaRepository.save(receta);
    }
    
    public Iterable<Receta> obtenerRecetasPorPaciente(String runPaciente) {
        return recetaRepository.findByRunPaciente(runPaciente);
    }
}