package pl.pawkoz.carrentalspringbootsecurity.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pawkoz.carrentalspringbootsecurity.model.Car;
import pl.pawkoz.carrentalspringbootsecurity.model.dto.CarDto;
import pl.pawkoz.carrentalspringbootsecurity.service.CarService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/for-admin")
public class CarController {
    private final CarService service;

    @GetMapping("/addcar")
    public String addCar(Model model){
        model.addAttribute("carDto", new CarDto());
        return "addCar";
    }

    @PostMapping("/addcar")
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
}
