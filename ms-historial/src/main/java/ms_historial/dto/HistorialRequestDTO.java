package ms_historial.dto;

import java.util.Date;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HistorialRequestDTO {

    @NotBlank(message = "El RUN del paciente es obligatorio")
    @Size(max = 15)
    private String runPaciente;

    @NotBlank(message = "El RUN del médico tratante es obligatorio")
    @Size(max = 15)
    private String runMedico;

    @NotBlank(message = "Debe ingresar un diagnóstico")
    private String diagnostico;

    private String tratamiento;

    @NotNull(message = "La fecha de atención es obligatoria")
    private Date fechaAtencion;

    private String observaciones;
}