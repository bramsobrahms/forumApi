package be.brahms.Forum.config.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Component
public class JwtUtil {

    private JwtBuilder builder;
    private JwtParser parser;

    public JwtUtil(){
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        parser = Jwts.parserBuilder().setSigningKey(key).build();
        builder = Jwts.builder().signWith(key);
    }

    public String getUsernameFromTooken(String token){
        return this.getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getClaimFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getClaimFromToken(String token){
        return parser.parseClaimsJws(token).getBody();
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put("creator", "Technofutur");

        return generateToken(claims, userDetails.getUsername());
    }

    private String generateToken(Map<String, Object> claims, String subject) {
        return builder.setClaims(claims).setSubject(subject).setIssuedAt(new Date()).compact();
    }
}
