package be.brahms.Forum.Models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Client extends Base<String>{

    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 200, nullable = false)
    private String firstName;

}
