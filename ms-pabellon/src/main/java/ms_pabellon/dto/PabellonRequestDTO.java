package ms_pabellon.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PabellonRequestDTO {

    @NotBlank(message = "El número o código de pabellón es obligatorio")
    private String numeroPabellon;

    @NotBlank(message = "El RUN del paciente es obligatorio")
    @Size(max = 15)
    private String runPaciente;

    @NotBlank(message = "El RUN del médico cirujano es obligatorio")
    @Size(max = 15)
    private String runMedico;

    @NotBlank(message = "El tipo de cirugía es obligatorio")
    private String tipoCirugia;

    @NotNull(message = "La fecha y hora de la cirugía son obligatorias")
    private Date fechaCirugia;
}