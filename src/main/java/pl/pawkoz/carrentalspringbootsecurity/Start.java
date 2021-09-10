package pl.pawkoz.carrentalspringbootsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.pawkoz.carrentalspringbootsecurity.model.AppUser;
import pl.pawkoz.carrentalspringbootsecurity.repository.AppUserRepo;

@Configuration
public class Start {
    private AppUserRepo appUserRepo;

    public Start(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {


        AppUser appUser = new AppUser();
        appUser.setUsername("Pawel");
        appUser.setPassword(passwordEncoder.encode("Pawel123"));
        appUser.setRole("ROLE_ADMIN");

        AppUser appUser2 = new AppUser();
        appUser2.setUsername("Kuba");
        appUser2.setPassword(passwordEncoder.encode("Kuba123"));
        appUser2.setRole("ROLE_USER");

        AppUser appUser3 = new AppUser();
        appUser3.setUsername("Wojti");
        appUser3.setPassword(passwordEncoder.encode("Wojti123"));
        appUser3.setRole("ROLE_USER");


//        appUserRepo.save(appUser);
//        appUserRepo.save(appUser2);
//        appUserRepo.save(appUser3);
    }
}
