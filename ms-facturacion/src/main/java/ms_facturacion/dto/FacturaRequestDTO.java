package ms_facturacion.dto;

import java.util.Date;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FacturaRequestDTO {

    @NotBlank(message = "El RUN del paciente es obligatorio")
    @Size(max = 15)
    private String runPaciente;

    @NotNull(message = "El monto total es obligatorio")
    @Min(value = 0, message = "El monto no puede ser negativo")
    private Integer montoTotal;

    @NotBlank(message = "Debe ingresar el detalle de los cargos")
    private String detalleCargos;

    @NotNull(message = "La fecha de emisión es obligatoria")
    private Date fechaEmision;
}