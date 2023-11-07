package be.brahms.Forum.Models.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor @AllArgsConstructor
@MappedSuperclass
@Data
public abstract class Base<T extends Serializable> {
    @Id
    @Getter
    private T id;
}
