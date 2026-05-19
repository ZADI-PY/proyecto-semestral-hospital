package ms_inventario.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InsumoRequestDTO {

    @NotBlank(message = "El nombre del insumo es obligatorio")
    private String nombre;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 0, message = "La cantidad no puede ser negativa")
    private Integer cantidad;

    @NotBlank(message = "La unidad de medida es obligatoria")
    private String unidadMedida;

    private String ubicacion;
}