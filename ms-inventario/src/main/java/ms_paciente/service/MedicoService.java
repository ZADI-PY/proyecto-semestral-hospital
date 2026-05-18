package ms_paciente.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms_paciente.model.Medico;
import ms_paciente.repository.MedicoRepository;

@Service
public class MedicoService {

    private static final Logger logger = LoggerFactory.getLogger(MedicoService.class);

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Medico findById(Integer id) throws Exception {
        try {
            return medicoRepository.findById(id)
                    .orElseThrow(() -> new Exception("Médico no encontrado con ID: " + id));
        } catch (Exception e) {
            logger.error("Error al buscar médico: {}", e.getMessage());
            throw e;
        }
    }

    public Medico save(Medico medico) {
        logger.info("Guardando médico con RUN: {}", medico.getRun());
        return medicoRepository.save(medico);
    }

    public void delete(Integer id) throws Exception {
        try {
            if (!medicoRepository.existsById(id)) {
                throw new Exception("No se puede eliminar. Médico no encontrado con ID: " + id);
            }
            medicoRepository.deleteById(id);
            logger.info("Médico con ID {} eliminado exitosamente", id);
        } catch (Exception e) {
            logger.error("Error al eliminar médico: {}", e.getMessage());
            throw e;
        }
    }
}