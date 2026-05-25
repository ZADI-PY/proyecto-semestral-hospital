package ms_medico.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MedicoRequestDTO {

    @NotBlank(message = "El RUN es obligatorio")
    @Size(max = 15, message = "El RUN no puede exceder los 15 caracteres")
    private String run;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @Email(message = "El correo debe tener un formato válido")
    private String correo;
}