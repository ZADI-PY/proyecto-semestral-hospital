package ms_facturacion.model;

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
@Table(name = "factura")
@Data
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "run_paciente", nullable = false, length = 15)
    private String runPaciente;

    @Column(nullable = false)
    private Integer montoTotal;

    @Column(nullable = false, length = 500)
    private String detalleCargos; // Ej: "Día cama, Insumos, Honorarios médicos"

    @Column(name = "fecha_emision", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;

    @Column(nullable = false, length = 20)
    private String estado; // Ej: "PENDIENTE", "PAGADA", "ANULADA"
}