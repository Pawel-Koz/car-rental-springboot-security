package pl.pawkoz.carrentalspringbootsecurity.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pl.pawkoz.carrentalspringbootsecurity.model.AppUser;
import pl.pawkoz.carrentalspringbootsecurity.repository.AppUserRepo;

import java.util.List;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {
    private final AppUserRepo userRepo;


    @Override
    public void addUser(AppUser appUser) {
        appUser.setPassword(BCrypt.hashpw(appUser.getPassword(), BCrypt.gensalt()));
        appUser.setRole("ROLE_USER");
        userRepo.save(appUser);

    }

    @Override
    public AppUser findByUsername(String userName) {
        return userRepo.findByUsername(userName).orElse(null);
    }

    @Override
    public AppUser showUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<AppUser> showAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public AppUser findByEmail(String email) {
        return userRepo.findAppUserByEmail(email).orElse(null);
    }

    @Override
    public void update(AppUser appUser) {

    }

    @Override
    public void delete(Long id) {

    }
}
