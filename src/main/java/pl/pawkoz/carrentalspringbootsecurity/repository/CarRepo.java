package pl.pawkoz.carrentalspringbootsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawkoz.carrentalspringbootsecurity.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepo extends JpaRepository<Car, Long> {

    List<Car> findAllByModel(String model);
    List<Car> findAllByMake(String make);
    Optional<Car> findByVin(String vin);
    Optional<Car> findById(Long id);
}
