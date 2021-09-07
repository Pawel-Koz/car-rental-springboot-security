package pl.pawkoz.carrentalspringbootsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawkoz.carrentalspringbootsecurity.model.AppUser;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findById(Long id);
    Optional<AppUser> findAppUserByEmail(String email);
    List<AppUser> findAll();


}
