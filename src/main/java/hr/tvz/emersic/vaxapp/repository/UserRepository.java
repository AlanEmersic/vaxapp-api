package hr.tvz.emersic.vaxapp.repository;

import hr.tvz.emersic.vaxapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUsername(String username);
}
