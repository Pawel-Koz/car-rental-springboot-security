package pl.pawkoz.carrentalspringbootsecurity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pawkoz.carrentalspringbootsecurity.model.Car;
import pl.pawkoz.carrentalspringbootsecurity.model.dto.CarDto;
import pl.pawkoz.carrentalspringbootsecurity.repository.CarRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;


    @Override
    public Car addCar(CarDto carDto) {
        Car car = new Car();
        if(carDto.getMake()!=null && carDto.getModel()!=null && carDto.getFuelType()!=null
                && carDto.getVin()!=null) {
            car.setMake(carDto.getMake());
            car.setModel(carDto.getModel());
            car.setAvailability(1);
            car.setVin(carDto.getVin());
            car.setFuelType(carDto.getFuelType());
            car.setMileage(carDto.getMileage());
            carRepo.save(car);
        }
        return car;
    }

    @Override
    public List<Car> showAll() {
        return carRepo.findAll();
    }

    @Override
    public Car showById(Long id) {
        return carRepo.findById(id).orElse(null);
    }

    @Override
    public Car showByVin(String vin) {
        return null;
    }

    @Override
    public Car update(CarDto carDto) {
        Car car = carRepo.getById(carDto.getId());
        if(carDto.getMake()!=null && carDto.getModel()!=null && carDto.getVin()!=null){
            car.setMake(carDto.getMake());
            car.setModel(carDto.getModel());
            car.setVin(carDto.getVin());
            car.setFuelType(carDto.getFuelType());
            car.setMileage(carDto.getMileage());
            carRepo.save(car);
        }
        return car;
    }

    @Override
    public void deleteById(Long id) {
        carRepo.deleteById(id);

    }
}
