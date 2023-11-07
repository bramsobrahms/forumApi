package be.brahms.Forum.services.user;

import be.brahms.Forum.Models.security.UserEntity;
import be.brahms.Forum.repositories.security.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserEntity register(UserEntity entity) {
        return this.userRepo.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepo.findOneByUsername(username).orElseThrow(()-> new UsernameNotFoundException(""));
    }
}
