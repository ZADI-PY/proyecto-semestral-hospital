package ms_paciente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MedicoRequestDTO {

    @NotBlank(message = "El RUN es obligatorio y no puede estar vacío")
    @Size(max = 15, message = "El RUN no puede tener más de 15 caracteres")
    private String run;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellidos;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El formato del correo electrónico no es válido")
    private String correo;
}