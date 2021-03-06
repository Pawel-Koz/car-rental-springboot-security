package pl.pawkoz.carrentalspringbootsecurity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.pawkoz.carrentalspringbootsecurity.model.AppUser;
import pl.pawkoz.carrentalspringbootsecurity.model.dto.UserDto;
import pl.pawkoz.carrentalspringbootsecurity.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@AllArgsConstructor
//@SessionAttributes("appUser")
public class UserController {
    private final UserService userService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {

        return "hello";
    }

    @GetMapping("/for-admin")
    public String forAdmin(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());
        return "hello-admin";
    }

    @GetMapping("/for-user")
    public String forUser() {
        return "hello-user";
    }

    @GetMapping("/sign-up")
    public String signup(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "sign-up";
    }

    @PostMapping("/register")
    public String register(@Valid UserDto userDto, BindingResult bindingResult) {
        AppUser userToCheck = userService.findByUsername(userDto.getUsername());
        if(!bindingResult.hasErrors() && userToCheck==null){
            userService.addUser(userDto);
            return "hello-user";
        } else {
            if(userToCheck!=null){
                bindingResult.rejectValue("username", "error.user", "taki uzytkownik juz istnieje");
                return "sign-up";
            }
            return "sign-up";

        }

    }


}

