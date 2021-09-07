package pl.pawkoz.carrentalspringbootsecurity.service;

import pl.pawkoz.carrentalspringbootsecurity.model.AppUser;

import java.util.List;

public interface UserService {

    void  addUser(AppUser appUser);
    AppUser findByUsername(String userName);
    AppUser showUser(Long id);
    List<AppUser> showAllUsers();
    AppUser findByEmail(String email);
    void update(AppUser appUser);
    void delete(Long id);

}
