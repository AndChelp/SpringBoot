package test.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 50)
    @Column(name = "firstname")
    private String firstName;

    @Size(min = 2, max = 50)
    @Column(name = "lastname")
    private String lastName;

    @Min(14)
    @Column(name = "age")
    private short age;

    @Column(name = "haspremium")
    private boolean hasPremium;

    @Column(name = "lastauthorization")
    private LocalDate lastAuthorization;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", firstName='" + firstName +
                ", lastName='" + lastName +
                ", age=" + age +
                ", hasPremium=" + hasPremium +
                ", lastAuthorization=" + lastAuthorization +
                '}';
    }
}
