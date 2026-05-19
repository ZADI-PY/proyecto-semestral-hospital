package ms_recetas.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RecetaRequestDTO {

    @NotBlank(message = "El RUN del paciente es obligatorio")
    @Size(max = 15)
    private String runPaciente;

    @NotBlank(message = "El RUN del médico es obligatorio")
    @Size(max = 15)
    private String runMedico;

    @NotBlank(message = "Debe ingresar al menos un medicamento")
    private String medicamentos;

    @NotBlank(message = "Las indicaciones médicas son obligatorias")
    private String indicaciones;

    @NotNull(message = "La fecha de emisión es obligatoria")
    private Date fechaEmision;
}