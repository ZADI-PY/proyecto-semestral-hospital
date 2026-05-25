package ms_camas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ms_camas.model.Cama;
import ms_camas.repository.CamaRepository;

@Service
public class CamaService {

    @Autowired
    private CamaRepository camaRepository;

    public Cama registrarCama(Cama cama) {
        // Toda cama nueva en el hospital parte como DISPONIBLE
        cama.setEstado("DISPONIBLE");
        return camaRepository.save(cama);
    }

    public Iterable<Cama> listarPorEstado(String estado) {
        return camaRepository.findByEstado(estado);
    }

    public Cama asignarPaciente(String numeroCama, String runPaciente) {
        Cama cama = camaRepository.findByNumeroCama(numeroCama)
                .orElseThrow(() -> new RuntimeException("Cama no encontrada en el sistema"));
        
        cama.setEstado("OCUPADA");
        cama.setRunPaciente(runPaciente);
        return camaRepository.save(cama);
    }
}