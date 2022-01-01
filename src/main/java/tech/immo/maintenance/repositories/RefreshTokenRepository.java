package tech.immo.maintenance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.immo.maintenance.models.RefreshToken;
import tech.immo.maintenance.models.User;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {

    Optional<RefreshToken> findById(int id);

    Optional<RefreshToken> findByToken(String token);

    int deleteByUser(User user);
}
