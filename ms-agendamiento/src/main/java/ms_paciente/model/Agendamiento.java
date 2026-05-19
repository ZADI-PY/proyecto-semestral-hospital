package ms_agendamiento.model;

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
@Table(name = "agendamiento")
@Data
public class Agendamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "run_paciente", nullable = false, length = 15)
    private String runPaciente;

    @Column(name = "run_medico", nullable = false, length = 15)
    private String runMedico;

    @Column(name = "tipo_consulta", nullable = false, length = 100)
    private String tipoConsulta; // Ej: "Consulta General", "Control Especialidad"

    @Column(name = "box_atencion", length = 20)
    private String boxAtencion; // Ej: "Box 12", "Telemedicina"

    @Column(name = "fecha_hora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @Column(nullable = false, length = 20)
    private String estado; // Ej: "VIGENTE", "CONFIRMADA", "ANULADA", "REALIZADA"
}