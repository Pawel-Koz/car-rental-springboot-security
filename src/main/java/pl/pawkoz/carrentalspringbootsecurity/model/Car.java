package pl.pawkoz.carrentalspringbootsecurity.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BINARY(16)")
    private Long id;
    private String model;
    private String make;
    private String vin;
    private String fuelType;
    private long mileage;
    private int availability;

}
