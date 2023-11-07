package be.brahms.Forum.repositories.security;

import be.brahms.Forum.Models.security.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.username = :username")
    Optional<UserEntity> findOneByUsername(@Param("username") String username);
}
