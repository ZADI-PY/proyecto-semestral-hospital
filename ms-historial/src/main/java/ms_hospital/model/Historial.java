package ms_historial.model;

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
@Table(name = "historial_medico")
@Data
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "run_paciente", nullable = false, length = 15)
    private String runPaciente;

    @Column(name = "run_medico", nullable = false, length = 15)
    private String runMedico;

    @Column(nullable = false, length = 255)
    private String diagnostico;

    @Column(length = 500)
    private String tratamiento;

    @Column(name = "fecha_atencion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAtencion;

    @Column(length = 500)
    private String observaciones;
}