package punchclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import punchclock.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
