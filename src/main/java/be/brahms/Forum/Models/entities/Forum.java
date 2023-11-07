package be.brahms.Forum.Models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Getter @Setter
@Entity
public class Forum extends Base<String>{
    @Column(columnDefinition = "TEXt", nullable = false)
    private String message;
    @CreatedDate
    private LocalDate createAt;
    @LastModifiedDate
    private LocalDate updateAt;

    @OneToOne
    private Client client;

}
