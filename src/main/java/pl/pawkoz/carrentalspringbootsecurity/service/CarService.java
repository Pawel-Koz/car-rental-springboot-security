package pl.pawkoz.carrentalspringbootsecurity.service;

import pl.pawkoz.carrentalspringbootsecurity.model.Car;
import pl.pawkoz.carrentalspringbootsecurity.model.dto.CarDto;
import pl.pawkoz.carrentalspringbootsecurity.repository.CarRepo;

import java.util.List;

public interface CarService {

    Car addCar(CarDto carDto);
    List<Car> showAll();
    Car showById(Long id);
    Car showByVin(String vin);
    Car update(CarDto carDto);
    void deleteById(Long id);

}
