package be.brahms.Forum.Models.security;

import be.brahms.Forum.Models.entities.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity(name = "Role")
@Table(name = "security_role")
@Data
public class RoleEntity extends Base<Integer> implements GrantedAuthority {

    @Column(nullable = false)
    private String label;

    @Override
    public String getAuthority() {
        return null;
    }
}
