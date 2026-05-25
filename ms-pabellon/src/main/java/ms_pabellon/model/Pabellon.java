package ms_pabellon.model;

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
@Table(name = "pabellon")
@Data
public class Pabellon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_pabellon", nullable = false, length = 10)
    private String numeroPabellon; // Ej: "PAB-01"

    @Column(name = "run_paciente", nullable = false, length = 15)
    private String runPaciente;

    @Column(name = "run_medico", nullable = false, length = 15)
    private String runMedico; // El cirujano a cargo

    @Column(name = "tipo_cirugia", nullable = false, length = 100)
    private String tipoCirugia;

    @Column(name = "fecha_cirugia", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCirugia;

    @Column(nullable = false, length = 20)
    private String estado; // Ej: "PROGRAMADA", "EN_CURSO", "FINALIZADA"
}