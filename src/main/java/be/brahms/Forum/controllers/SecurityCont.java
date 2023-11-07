package be.brahms.Forum.controllers;

import be.brahms.Forum.Models.forms.security.SignInF;
import be.brahms.Forum.Models.security.SignInDTO;
import be.brahms.Forum.Models.security.UserEntity;
import be.brahms.Forum.config.jwt.JwtUtil;
import be.brahms.Forum.services.user.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityCont {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public SecurityCont(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping(path = {"/login"})
    public SignInDTO signAction(@RequestBody SignInF form){
        UserDetails ud = this.userService.loadUserByUsername(form.username());

        if(passwordEncoder.matches(form.password(), ud.getPassword())){
            String token = jwtUtil.generateToken(ud);
            return new SignInDTO(token, ud);
        }
        return null;
    }

    @PostMapping(path = {"/register"})
    public UserDetails registerAction( @RequestBody SignInF form){
        UserEntity entity = new UserEntity();
        entity.setId(form.username());
        entity.setUsername(form.username());
        entity.setPassword(passwordEncoder.encode(form.password()));

        return this.userService.register(entity);
    }
}
