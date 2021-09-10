package pl.pawkoz.carrentalspringbootsecurity.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.pawkoz.carrentalspringbootsecurity.model.Car;
import pl.pawkoz.carrentalspringbootsecurity.model.dto.CarDto;
import pl.pawkoz.carrentalspringbootsecurity.service.CarService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class CarController {
    private final CarService service;

    @GetMapping("/for-admin/addcar")
    public String addCar(Model model){
        model.addAttribute("carDto", new CarDto());
        return "addCar";
    }

    @PostMapping("/for-admin/addcar")
    public String addCar(@Valid CarDto carDto, BindingResult result){
        Car carToCheck = service.showByVin(carDto.getVin());
        if(result.hasErrors() && carToCheck==null){
            service.addCar(carDto);
            return "hello-admin";
        }else{
            if(carToCheck!=null){
                result.rejectValue("vin", "error.carDto", "car with this vin exists");

            }
            return "addCar";
        }

    }

    @GetMapping("/for-admin/listcars")
    public String listCars(Model model){
        model.addAttribute("cars", service.showAll());
        return "listCars";
    }

    @GetMapping("/for-user/listcars")
    public String listCarsForUser(Model model){
        model.addAttribute("cars", service.showAll());
        return "listCars";
    }
    @GetMapping("/for-admin/update")
    public String updateCar(Model model, @RequestParam long id){
        Car car = service.showById(id);
        model.addAttribute("carDto", car);
        return "updateCar";
    }
    @PostMapping("/for-admin/update")
    public String updateCar(@Valid CarDto carDto, BindingResult result){
        if(!result.hasErrors()){
            service.update(carDto);
            return "hello-admin";
        } else {
            return "updateCar";
        }

    }

    


}
