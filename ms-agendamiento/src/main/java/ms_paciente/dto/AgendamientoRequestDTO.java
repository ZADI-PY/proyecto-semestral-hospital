package ms_agendamiento.dto;

import java.util.Date;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AgendamientoRequestDTO {

    @NotBlank(message = "El RUN del paciente es obligatorio")
    @Size(max = 15)
    private String runPaciente;

    @NotBlank(message = "El RUN del médico es obligatorio")
    @Size(max = 15)
    private String runMedico;

    @NotBlank(message = "Debe indicar el tipo de consulta")
    private String tipoConsulta;

    private String boxAtencion;

    @NotNull(message = "La fecha y hora de la cita son obligatorias")
    private Date fechaHora;
}