package ms_pabellon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms_pabellon.model.Pabellon;
import ms_pabellon.repository.PabellonRepository;

@Service
public class PabellonService {

    @Autowired
    private PabellonRepository pabellonRepository;

    public Pabellon agendarCirugia(Pabellon pabellon) {
        // Por regla de negocio, una cirugía nueva siempre nace como PROGRAMADA
        pabellon.setEstado("PROGRAMADA");
        return pabellonRepository.save(pabellon);
    }

    public Iterable<Pabellon> listarPorEstado(String estado) {
        return pabellonRepository.findByEstado(estado);
    }
}