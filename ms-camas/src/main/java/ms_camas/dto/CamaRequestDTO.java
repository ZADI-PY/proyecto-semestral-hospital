package ms_camas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CamaRequestDTO {

    @NotBlank(message = "El número o código de la cama es obligatorio")
    private String numeroCama;

    @NotBlank(message = "La sala o sector es obligatorio")
    private String sala;
}