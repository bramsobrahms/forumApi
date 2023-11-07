package be.brahms.Forum.services.user;

import be.brahms.Forum.Models.security.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserEntity register(UserEntity entity);
}
