package ms_paciente.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ms_paciente.model.Paciente;
import ms_paciente.repository.PacienteRepository;

@Service
@Transactional

public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Paciente findById(Integer id) {
        return pacienteRepository.findById(id).get();
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void delete(Integer id) {
        pacienteRepository.deleteById(id);
    }
}

