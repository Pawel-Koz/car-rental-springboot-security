package pl.pawkoz.carrentalspringbootsecurity.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pawkoz.carrentalspringbootsecurity.model.dto.CarDto;
import pl.pawkoz.carrentalspringbootsecurity.service.CarService;

@Controller
@AllArgsConstructor
@RequestMapping("/for-admin")
public class CarController {
    private final CarService service;

    @GetMapping("/addcar")
    public String addCar(Model model){
        model.addAttribute("carDto", new CarDto());
        return "/cars/addCar";
    }
}
