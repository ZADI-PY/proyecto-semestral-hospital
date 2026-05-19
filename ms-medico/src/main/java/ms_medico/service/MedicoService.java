package ms_medico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ms_medico.model.Medico;
import ms_medico.repository.MedicoRepository;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico registrarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Optional<Medico> buscarPorRun(String run) {
        return medicoRepository.findByRun(run);
    }

    public Iterable<Medico> listarTodos() {
        return medicoRepository.findAll();
    }
}