package pl.pawkoz.carrentalspringbootsecurity.service;

import pl.pawkoz.carrentalspringbootsecurity.model.AppUser;
import pl.pawkoz.carrentalspringbootsecurity.model.dto.UserDto;

import java.util.List;

public interface UserService {

    AppUser  addUser(UserDto userDto);
    AppUser findByUsername(String userName);
    AppUser showUser(Long id);
    List<AppUser> showAllUsers();
    AppUser findByEmail(String email);
    void update(AppUser appUser);
    void delete(Long id);

}
