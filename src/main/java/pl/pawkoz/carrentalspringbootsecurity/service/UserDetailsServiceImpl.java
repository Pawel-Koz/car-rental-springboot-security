package pl.pawkoz.carrentalspringbootsecurity.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.pawkoz.carrentalspringbootsecurity.repository.AppUserRepo;
@Service

public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepo appUserRepo;

    public UserDetailsServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //to do dorobic or else throw if not exists
        return appUserRepo.findByUsername(s).orElse(null);
    }
}
