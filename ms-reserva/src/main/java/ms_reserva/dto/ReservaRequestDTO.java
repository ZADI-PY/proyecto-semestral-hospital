package ms_reserva.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReservaRequestDTO {

    @NotBlank(message = "El RUN del paciente es obligatorio")
    @Size(max = 15, message = "El RUN máximo es de 15 caracteres")
    private String runPaciente;

    @NotBlank(message = "El RUN del médico es obligatorio")
    @Size(max = 15, message = "El RUN máximo es de 15 caracteres")
    private String runMedico;

    @NotNull(message = "La fecha y hora son obligatorias")
    private Date fechaHora;
}