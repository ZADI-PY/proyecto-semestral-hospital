package ms_recetas.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "receta")
@Data
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "run_paciente", nullable = false, length = 15)
    private String runPaciente;

    @Column(name = "run_medico", nullable = false, length = 15)
    private String runMedico;

    @Column(nullable = false, length = 255)
    private String medicamentos;

    @Column(nullable = false, length = 500)
    private String indicaciones;

    @Column(name = "fecha_emision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
}