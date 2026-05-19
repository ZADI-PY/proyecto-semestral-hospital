package ms_camas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cama")
@Data
public class Cama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_cama", nullable = false, length = 10, unique = true)
    private String numeroCama; // Ej: "C-101", "C-102"

    @Column(nullable = false, length = 50)
    private String sala; // Ej: "UCI", "Pediatría", "Medicina General"

    @Column(nullable = false, length = 20)
    private String estado; // Ej: "DISPONIBLE", "OCUPADA", "MANTENCION"

    @Column(name = "run_paciente", length = 15)
    private String runPaciente; // Null si la cama está disponible
}