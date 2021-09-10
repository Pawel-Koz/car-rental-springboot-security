package pl.pawkoz.carrentalspringbootsecurity.model.dto;



import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CarDto {
    private Long id;

    @NotNull
    @Size(min = 1, max = 30)
    private String make;

    @NotNull
    @Size(min = 1, max = 30)
    private String model;

    @NotNull
    @Size(min = 1, max = 10)
    private String fuelType;

    @Size(min = 2, max = 10)
    private String vin;

    @NotNull
    private Long mileage;
    private int availability;

}
