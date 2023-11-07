package be.brahms.Forum.Models.security;

import org.springframework.security.core.userdetails.UserDetails;

public record SignInDTO(
        String token,
        UserDetails user
) {
}
