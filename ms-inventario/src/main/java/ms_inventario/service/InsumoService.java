package ms_inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ms_inventario.model.Insumo;
import ms_inventario.repository.InsumoRepository;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    public Insumo guardarInsumo(Insumo insumo) {
        return insumoRepository.save(insumo);
    }

    public Iterable<Insumo> listarTodos() {
        return insumoRepository.findAll();
    }

    public Iterable<Insumo> buscarPorNombre(String nombre) {
        return insumoRepository.findByNombreContainingIgnoreCase(nombre);
    }
}