package ms_historial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ms_historial.model.Historial;
import ms_historial.repository.HistorialRepository;

@Service
public class HistorialService {

    @Autowired
    private HistorialRepository historialRepository;

    public Historial registrarAtencion(Historial historial) {
        return historialRepository.save(historial);
    }

    public Iterable<Historial> obtenerHistorialPorPaciente(String runPaciente) {
        return historialRepository.findByRunPacienteOrderByFechaAtencionDesc(runPaciente);
    }
}
    }
}

